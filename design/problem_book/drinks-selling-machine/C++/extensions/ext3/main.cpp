#include "../../base/ClientQueueMachineHandler.h"
#include "IngredientOperator.h"

int main()
{
	ClientQueueMachineHandler<Client, DrinkSellingMachine<IngredientOperatorWithMistake>> cqm;
	cqm.run();

	return 0;
}
