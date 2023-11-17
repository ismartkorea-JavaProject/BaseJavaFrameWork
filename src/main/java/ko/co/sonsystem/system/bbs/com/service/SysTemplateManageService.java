package ko.co.sonsystem.system.bbs.com.service;

import java.util.List;
import java.util.Map;

/**
 * 템플릿 관리를 위한 서비스 인터페이스 클래스
 * @author s-onsystem
 * @since 2023.11.16
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 * 
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2023.11.16  jeong          최초 생성
 *
 *  </pre>
 */
public interface SysTemplateManageService {

	/**
	 * 템플릿 정보를 삭제한다.
	 * 
	 * @param tmplatInf
	 * @exception Exception Exception
	 */
	public void deleteTemplateInf(TemplateInf tmplatInf)
	  throws Exception;

	/**
	 * 템플릿 정보를 등록한다.
	 * 
	 * @param tmplatInf
	 * @exception Exception Exception
	 */
	public void insertTemplateInf(TemplateInf tmplatInf)
	  throws Exception;

	/**
	 * 템플릿에 대한 상세정보를 조회한다.
	 * @return
	 * 
	 * @param tmplatInfVO
	 * @exception Exception Exception
	 */
	public TemplateInfVO selectTemplateInf(TemplateInfVO tmplatInfVO)
	  throws Exception;

	/**
	 * 템플릿에 대한 목록를 조회한다.
	 * @return
	 * 
	 * @param tmplatInfVO
	 * @exception Exception Exception
	 */
	public Map<String, Object> selectTemplateInfs(TemplateInfVO tmplatInfVO)
	  throws Exception;

	/**
	 * 템플릿 구분에 따른 목록을 조회한다.
	 * @return
	 * 
	 * @param tmplatInfVO
	 * @exception Exception Exception
	 */
	public List<TemplateInfVO> selectTemplateInfsByCode(TemplateInfVO tmplatInfVO)
	  throws Exception;

	/**
	 * 템플릿에 대한 미리보기 정보를 조회한다.
	 * @return
	 * 
	 * @param tmplatInfVO
	 * @exception Exception Exception
	 */
	public TemplateInfVO selectTemplatePreview(TemplateInfVO tmplatInfVO)
	  throws Exception;

	/**
	 * 템플릿 정보를 수정한다.
	 * 
	 * @param tmplatInf
	 * @exception Exception Exception
	 */
	public void updateTemplateInf(TemplateInf tmplatInf)
	  throws Exception;

}