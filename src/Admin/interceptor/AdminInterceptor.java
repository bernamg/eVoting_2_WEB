/**
 * Raul Barbosa 2014-11-07
 */
package Admin.interceptor;

import Admin.action.AdminAction;
import Admin.action.CreateUserAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Calendar;
import java.util.Map;

public class AdminInterceptor implements Interceptor {
	private static final long serialVersionUID = 189237412378L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();

		// this method intercepts the execution of the action and we get access
		// to the session, to the action, and to the context of this invocation
		System.out.println("reusult: "+(invocation.getAction() instanceof CreateUserAction));
		if(invocation.getAction() instanceof AdminAction){
			System.out.println("here return login");
			return Action.LOGIN;
		}else{
			System.out.println("outro return");
			return invocation.invoke();
		}

	}

	@Override
	public void init() { }
	
	@Override
	public void destroy() { }
}