import Association.Budget;
import org.junit.Test;

import static org.junit.Assert.*;
import Events.*;
import Jobs.*;
import Game.*;
import Association.*;
import System.*;
import User.*;

public class BudgetTest {

    @Test
    public void budgetTest(){
        Budget budget=new Budget(null);
        assertTrue(budget.getReports().size()==0);
        assertTrue(0==budget.getBudget());
        budget.addWithdraw((double) 100,"Withdraw");
        assertTrue(budget.getReports().size()==1);
        assertTrue(-100==budget.getBudget());
        budget.addDeposit((double) 500,"Deposit");
        assertTrue(400==budget.getBudget());
        assertTrue(budget.getReports().size()==2);

    }
}
