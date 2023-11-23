package ko.co.sonsystem.mng.cmm.code.detail.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.CmmnDetailCode;
import ko.co.sonsystem.mng.cmm.code.detail.service.CmmnDetailCodeVO;
import ko.co.sonsystem.mng.cmm.code.detail.service.SysCcmCmmnDetailCodeManageService;



/**
 *
 * 공통상세코드에 대한 서비스 구현클래스를 정의한다
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
@Service("SysCcmCmmnDetailCodeManageService")
public class SysCcmCmmnDetailCodeManageServiceImpl extends EgovAbstractServiceImpl implements SysCcmCmmnDetailCodeManageService {

    @Resource(name="SysCmmnDetailCodeManageDAO")
    private SysCmmnDetailCodeManageDAO cmmnDetailCodeManageDAO;

	/**
	 * 공통상세코드를 삭제한다.
	 */
	@Override
	public void deleteCmmnDetailCode(CmmnDetailCode cmmnDetailCode) throws Exception {
		cmmnDetailCodeManageDAO.deleteCmmnDetailCode(cmmnDetailCode);
	}

	/**
	 * 공통상세코드를 등록한다.
	 */
	@Override
	public void insertCmmnDetailCode(CmmnDetailCode cmmnDetailCode) throws Exception {
    	cmmnDetailCodeManageDAO.insertCmmnDetailCode(cmmnDetailCode);
	}

	/**
	 * 공통상세코드 상세항목을 조회한다.
	 */
	@Override
	public CmmnDetailCode selectCmmnDetailCodeDetail(CmmnDetailCode cmmnDetailCode) throws Exception {
    	CmmnDetailCode ret = cmmnDetailCodeManageDAO.selectCmmnDetailCodeDetail(cmmnDetailCode);
    	return ret;
	}

	/**
	 * 공통상세코드 목록을 조회한다.
	 */
	@Override
	public List<?> selectCmmnDetailCodeList(CmmnDetailCodeVO searchVO) throws Exception {
        return cmmnDetailCodeManageDAO.selectCmmnDetailCodeList(searchVO);
	}

	/**
	 * 공통상세코드 총 갯수를 조회한다.
	 */
	@Override
	public int selectCmmnDetailCodeListTotCnt(CmmnDetailCodeVO searchVO) throws Exception {
        return cmmnDetailCodeManageDAO.selectCmmnDetailCodeListTotCnt(searchVO);
	}

	/**
	 * 공통상세코드를 수정한다.
	 */
	@Override
	public void updateCmmnDetailCode(CmmnDetailCode cmmnDetailCode) throws Exception {
		cmmnDetailCodeManageDAO.updateCmmnDetailCode(cmmnDetailCode);
	}

}
