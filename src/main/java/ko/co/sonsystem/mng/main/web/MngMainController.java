package ko.co.sonsystem.mng.main.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.com.cmm.ComDefaultVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 템플릿 메인 페이지 컨트롤러 클래스(Sample 소스)
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
@Controller@SessionAttributes(types = ComDefaultVO.class)
public class MngMainController {
	
	/**
	 * 메인 페이지 뷰 호출.
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mng/main/mainPageView.do")
	public String getMgtMainPageView(HttpServletRequest request, ModelMap model) throws Exception {
		
		log.debug("### MngMainController::getMngMainPageView Called !!! ###");
		
		return "mng/main/mngMainView";
	}

}