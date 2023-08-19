import copy
import datetime

from .machine_elements.components import IngredientOperator
from base.config.settings import RECEIPTS, COMPONENTS, MACHINE
from base.abstract.interfaces import IOrderable
from .goods.drinks import CookedDrink
from .machine_elements.storages import PreReadyGoodsStorage, IngredientStorage


class DrinkSellingMachine(IOrderable):
    def __init__(self, component_cls=None):
        if component_cls:
            self._components = {name: component_cls(name=name, ingredients=COMPONENTS[name]['ingredients'])
                            for name in COMPONENTS}
        else:
            self._components = {name: IngredientOperator(name=name, ingredients=COMPONENTS[name]['ingredients'])
                                for name in COMPONENTS}
        self._storages = {'Ingredients storage': IngredientStorage(name='Ingredients storage'),
                           'Pre-ready goods fridge': PreReadyGoodsStorage(name='Pre-ready goods fridge')}
        self.__receipts = copy.deepcopy(RECEIPTS)
        self.__work_start = datetime.datetime.now()
        self.__work_delta = datetime.timedelta(seconds=MACHINE['work_delta'])

    def is_available(self):
        if datetime.datetime.now() > (self.__work_start + self.__work_delta):
            return False
        else:
            return True

    def get_menu(self):
        return list(
            list(self.__receipts.keys()) + list(self._storages['Pre-ready goods fridge'].get_current_state().keys()))

    def make_order(self, ordered_position):
        res = self._execute_order(ordered_position)
        if res is not False:
            return res
        else:
            return False

    def is_position_avaliable(self, position):
        res = self._check_order_possibility(position)
        return res

    def _get_receipt(self, required_drink):
        receipt = {required_drink: copy.deepcopy(self.__receipts[required_drink])}
        return receipt

    def _execute_receipt(self, receipt, required_drink):
        # storage = self._storages['Ingredients storage']
        result_list = {stage: False for stage in receipt[required_drink]}
        required_components = {stage: receipt[required_drink][stage]['component'] for stage in
                               receipt[required_drink]}
        required_ingredients = {key: False for key in receipt[required_drink]}
        ingr_check = True
        while False in result_list.values():
            ingr_check = self._get_required_ingredients(receipt[required_drink], required_ingredients)
            if ingr_check is False:
                break
            for stage in required_components:
                self._components[required_components[stage]].pass_receipt_ingredient(required_drink, stage)
            # loop = asyncio.get_event_loop()
            # result = loop.run_until_complete(self._trigger_operations(required_components))
            result = self._trigger_operations(required_components)
            result_list = dict(result)
            vals_to_del = []
            for ingr in result_list:
                if result_list[ingr]:
                    # del result_list[ingr]
                    del required_components[ingr]
                    vals_to_del.append(ingr)
            for val in vals_to_del:
                del result_list[val]
        if False in result_list.values():
            return False
        else:
            return CookedDrink(name=required_drink)

    def _get_required_ingredients(self, receipt, prev_extraction_info):
        for stage in prev_extraction_info:
            if prev_extraction_info[stage]:
                del prev_extraction_info[stage]
            else:
                pass
        s = self._storages['Ingredients storage'].get_receipt_ingredients(prev_extraction_info, receipt)
        return s

    def _trigger_operations(self, req_comps) -> list:
        result = [self._components[req_comps[comp]].operate_ingredient() for comp in req_comps]
        # for comp in req_comps:
        #     my_list.append(asyncio.create_task(self._components[req_comps[comp]].operate_ingredient()))
        # result = await asyncio.gather(*my_list, return_exceptions=False)
        return result

    def _execute_order(self, required_drink):
        poss = self._check_order_possibility(required_drink)
        if poss:
            if required_drink not in self.__receipts:
                res = self._get_pre_ready_good(required_drink)
            else:
                receipt = self._get_receipt(required_drink)
                res = self._execute_receipt(receipt, required_drink)
            return res
        else:
            return False

    def _check_order_possibility(self, order) -> bool:
        if order in self._storages['Pre-ready goods fridge']:
            if self._storages['Pre-ready goods fridge'].check_stored_item(order, 1):
                return True
            else:
                return False
        elif order in self.__receipts:
            ingred_cur_state = self._storages['Ingredients storage'].get_current_state()
            for ingred in self.__receipts[order]:
                if self.__receipts[order][ingred]['amount'] > ingred_cur_state[ingred]:
                    return False
                else:
                    pass
            return True
        else:
            return False

    def _get_pre_ready_good(self, name):
        result = self._storages['Pre-ready goods fridge'].get_element(name, 1)
        return result
