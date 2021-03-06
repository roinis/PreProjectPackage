import org.junit.Test;

import static org.junit.Assert.*;
import Game.*;
import User.*;
import System.*;
import Jobs.*;
import Events.*;
import Association.*;

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
        AlphaSystem alphaSystem=AlphaSystem.getSystem();
        alphaSystem.ResetDB();
    }
}
