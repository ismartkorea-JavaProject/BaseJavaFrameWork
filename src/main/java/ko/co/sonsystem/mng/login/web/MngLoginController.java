package ko.co.sonsystem.mng.login.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * 로그인 화면을 처리하는 컨트롤러 클래스
 * @author s-onsystem
 * @since 2023.11.16
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2023.11.16  jeong          최초 생성
 *
 * </pre>
 */
@Slf4j
@Controller
public class MngLoginController {
	
	
	@RequestMapping(value = "/mng/login/loginView.do")
	public String loginView(HttpServletResponse response, HttpServletRequest request, ModelMap model) throws Exception {
		
		// 접속IP
		log.debug("### MngLoginController::loginView");
		
		return "/mng/login/login";
	}

}
