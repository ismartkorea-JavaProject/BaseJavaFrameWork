package ko.co.sonsystem.mng.cmm.clcode.web;

import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.LoginVO;
import ko.co.sonsystem.mng.cmm.clcode.service.CmmnClCode;
import ko.co.sonsystem.mng.cmm.clcode.service.CmmnClCodeVO;
import ko.co.sonsystem.mng.cmm.clcode.service.SysCcmCmmnClCodeManageService;
/**
 *
 * 공통분류코드에 관한 요청을 받아 서비스 클래스로 요청을 전달하고 서비스클래스에서 처리한 결과를 웹 화면으로 전달을 위한 Controller를 정의한다
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
@Controller
public class SysCcmCmmnClCodeManageController {
	@Resource(name = "SysCcmCmmnClCodeManageService")
    private SysCcmCmmnClCodeManageService cmmnClCodeManageService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

	@Autowired
	private DefaultBeanValidator beanValidator;

	/**
	 * 공통분류코드를 삭제한다.
	 * @param loginVO
	 * @param cmmnClCode
	 * @param model
	 * @return "forward:/sym/ccm/ccc/EgovCcmCmmnClCodeList.do"
	 * @throws Exception
	 */
    @RequestMapping(value="/mng/cmm/clcode/SysCcmCmmnClCodeRemove.do")
	public String deleteCmmnClCode (@ModelAttribute("loginVO") LoginVO loginVO
			, CmmnClCode cmmnClCode
			, ModelMap model
			) throws Exception {
    	 cmmnClCodeManageService.deleteCmmnClCode(cmmnClCode);
        return "forward:/mng/cmm/clcode/SysCcmCmmnClCodeList.do";
	}

	/**
	 * 공통분류코드를 등록한다.
	 * @param loginVO
	 * @param cmmnClCode
	 * @param bindingResult
	 * @return "/cmm/sym/ccm/EgovCcmCmmnClCodeRegist"
	 * @throws Exception
	 */
    @RequestMapping(value="/mng/cmm/clcode/SysCcmCmmnClCodeRegist.do")
	public String insertCmmnClCode (@ModelAttribute("loginVO") LoginVO loginVO
			, @ModelAttribute("cmmnClCode") CmmnClCode cmmnClCode
			, BindingResult bindingResult
			) throws Exception {
    	if   (cmmnClCode.getClCode() == null
    		||cmmnClCode.getClCode().equals("")) {
    		return "/mng/cmm/clcode/SysCcmCmmnClCodeRegist";
    	}

        beanValidator.validate(cmmnClCode, bindingResult);
		if (bindingResult.hasErrors()){
    		return "/mng/cmm/clcode/SysCcmCmmnClCodeRegist";
		}

    	cmmnClCode.setFrstRegisterId(loginVO.getUniqId());
    	cmmnClCodeManageService.insertCmmnClCode(cmmnClCode);
        return "forward:/mng/cmm/clcode/SysCcmCmmnClCodeList.do";
    }

	/**
	 * 공통분류코드 상세항목을 조회한다.
	 * @param loginVO
	 * @param cmmnClCode
	 * @param model
	 * @return "cmm/sym/ccm/EgovCcmCmmnClCodeDetail"
	 * @throws Exception
	 */
	@RequestMapping(value="/mng/cmm/clcode/SysCcmCmmnClCodeDetail.do")
 	public String selectCmmnClCodeDetail (@ModelAttribute("loginVO") LoginVO loginVO
 			, CmmnClCode cmmnClCode
 			, ModelMap model
 			) throws Exception {
		CmmnClCode vo = cmmnClCodeManageService.selectCmmnClCodeDetail(cmmnClCode);
		model.addAttribute("result", vo);

		return "mng/cmm/clcode/SysCcmCmmnClCodeDetail";
	}

    /**
	 * 공통분류코드 목록을 조회한다.
     * @param loginVO
     * @param searchVO
     * @param model
     * @return "/cmm/sym/ccm/EgovCcmCmmnClCodeList"
     * @throws Exception
     */
    @RequestMapping(value="/mng/cmm/clcode/SysCcmCmmnClCodeList.do")
	public String selectCmmnClCodeList (@ModelAttribute("loginVO") LoginVO loginVO
			, @ModelAttribute("searchVO") CmmnClCodeVO searchVO
			, ModelMap model
			) throws Exception {

/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));

    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

        model.addAttribute("resultList", cmmnClCodeManageService.selectCmmnClCodeList(searchVO));

        int totCnt = cmmnClCodeManageService.selectCmmnClCodeListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);

        return "/mng/cmm/clcode/SysCcmCmmnClCodeList";
	}

	/**
	 * 공통분류코드를 수정한다.
	 * @param loginVO
	 * @param cmmnClCode
	 * @param bindingResult
	 * @param commandMap
	 * @param model
	 * @return "/cmm/sym/ccm/EgovCcmCmmnClCodeModify"
	 * @throws Exception
	 */
    @RequestMapping(value="/mng/cmm/clcode/SysCcmCmmnClCodeModify.do")
	public String updateCmmnClCode (@ModelAttribute("loginVO") LoginVO loginVO
			, @ModelAttribute("administCode") CmmnClCode cmmnClCode
			, BindingResult bindingResult
			, @RequestParam Map <String, Object> commandMap
			, ModelMap model
			) throws Exception {
		String sCmd = commandMap.get("cmd") == null ? "" : (String)commandMap.get("cmd");
    	if (sCmd.equals("")) {
    		CmmnClCode vo = cmmnClCodeManageService.selectCmmnClCodeDetail(cmmnClCode);
    		model.addAttribute("cmmnClCode", vo);

    		return "/mng/cmm/clcode/SysCcmCmmnClCodeModify";
    	} else if (sCmd.equals("Modify")) {
            beanValidator.validate(cmmnClCode, bindingResult);
    		if (bindingResult.hasErrors()){
        		CmmnClCode vo = cmmnClCodeManageService.selectCmmnClCodeDetail(cmmnClCode);
        		model.addAttribute("cmmnClCode", vo);

        		return "/mng/cmm/clcode/SysCcmCmmnClCodeModify";
    		}
    		cmmnClCode.setLastUpdusrId(loginVO.getUniqId());
	    	cmmnClCodeManageService.updateCmmnClCode(cmmnClCode);
	        return "forward:/mng/cmm/clcode/SysCcmCmmnClCodeList.do";
    	} else {
    		return "forward:/mng/cmm/clcode/SysCcmCmmnClCodeList.do";
    	}
    }

}