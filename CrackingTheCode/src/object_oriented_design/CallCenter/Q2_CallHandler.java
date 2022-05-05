package object_oriented_design.CallCenter;

import java.util.ArrayList;
import java.util.List;

/* CallHandler represents the body of the program,
 * and all calls are funneled first through it. 
 */

public class Q2_CallHandler {
	
	/* We have 3 levels of employees: respondents, managers, directors. */
    private final int LEVELS = 3; 
    
    /* Initialize with 10 respondents, 4 managers, and 2 directors. */
    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    /* List of employees, by level.
     * employeeLevels[0] = respondents
     * employeeLevels[1] = managers
     * employeeLevels[2] = directors
     */
    List<List<Q2_Employee>> employeeLevels;

	/* queues for each call�s rank */
    List<List<Q2_Call>> callQueues; 

    public Q2_CallHandler() {
    	employeeLevels = new ArrayList<List<Q2_Employee>>(LEVELS);
    	callQueues = new ArrayList<List<Q2_Call>>(LEVELS); 
    	
        // Create respondents.
        ArrayList<Q2_Employee> respondents = new ArrayList<Q2_Employee>(NUM_RESPONDENTS);
        for (int k = 0; k < NUM_RESPONDENTS - 1; k++) {
            respondents.add(new Q2_Respondent(this));
        }
        employeeLevels.add(respondents);

        // Create managers.
        ArrayList<Q2_Employee> managers = new ArrayList<Q2_Employee>(NUM_MANAGERS);
        managers.add(new Q2_Manager(this));
        employeeLevels.add(managers);

        // Create directors.
        ArrayList<Q2_Employee> directors = new ArrayList<Q2_Employee>(NUM_DIRECTORS);
        directors.add(new Q2_Director(this));
        employeeLevels.add(directors);
    }
    
    /* Gets the first available employee who can handle this call. */
    public Q2_Employee getHandlerForCall(Q2_Call call) {
        for (int level = call.getRank().getValue(); level < LEVELS - 1; level++) {
            List<Q2_Employee> employeeLevel = employeeLevels.get(level);
            for (Q2_Employee emp : employeeLevel) {
                if (emp.isFree()) {
                    return emp;
                }
            }
        }
        return null;
    }

    /* Routes the call to an available employee, or saves in a queue if no employee available. */
    public void dispatchCall(Q2_Caller caller) {
    	Q2_Call call = new Q2_Call(caller);
    	dispatchCall(call);
    }
    
    /* Routes the call to an available employee, or saves in a queue if no employee available. */
    public void dispatchCall(Q2_Call call) {
    	/* Try to route the call to an employee with minimal rank. */
        Q2_Employee emp = getHandlerForCall(call);
        if (emp != null) {
        	emp.receiveCall(call);
        	call.setHandler(emp);
        } else {
	        /* Place the call into corresponding call queue according to its rank. */
	        call.reply("Please wait for free employee to reply");
	        callQueues.get(call.getRank().getValue()).add(call);
        }
    }    

    /* An employee got free. Look for a waiting call that he/she can serve. Return true
     * if we were able to assign a call, false otherwise. */
    public boolean assignCall(Q2_Employee emp) {
        /* Check the queues, starting from the highest rank this employee can serve. */
        for (int rank = emp.getRank().getValue(); rank >= 0; rank--) {
            List<Q2_Call> que = callQueues.get(rank);
            
            /* Remove the first call, if any */
            if (que.size() > 0) {
	            Q2_Call call = que.remove(0); 
	            if (call != null) {
	                emp.receiveCall(call);
	                return true;
	            }
            }
        }
        return false;
    }
	
	

}
