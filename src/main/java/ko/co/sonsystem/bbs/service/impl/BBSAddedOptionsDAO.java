package ko.co.sonsystem.bbs.service.impl;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import ko.co.sonsystem.bbs.service.BoardMaster;
import ko.co.sonsystem.bbs.service.BoardMasterVO;

/**
 * 2단계 기능 추가 (댓글관리, 만족도조사) 관리를 위한 데이터 접근 클래스
 * @author 공통 서비스 개발팀 한성곤
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
@Repository("BBSAddedOptionsDAO")
public class BBSAddedOptionsDAO extends EgovAbstractMapper {

    /**
     * 신규 게시판 추가기능 정보를 등록한다.
     * 
     * @param BoardMaster
     */
    public int insertAddedOptionsInf(BoardMaster boardMaster) throws Exception {
	return insert("BBSAddedOptionsDAO.insertAddedOptionsInf", boardMaster);
    }
    
    /**
     * 게시판 추가기능 정보 한 건을 상세조회 한다.
     * 
     * @param BoardMasterVO
     */
    public BoardMasterVO selectAddedOptionsInf(BoardMaster vo) throws Exception {
	return (BoardMasterVO)selectOne("BBSAddedOptionsDAO.selectAddedOptionsInf", vo);
    }
    
    /**
     * 게시판 추가기능 정보를 수정한다.
     * 
     * @param BoardMaster
     */
    public void updateAddedOptionsInf(BoardMaster boardMaster) throws Exception {
	update("BBSAddedOptionsDAO.updateAddedOptionsInf", boardMaster);
    }
}
