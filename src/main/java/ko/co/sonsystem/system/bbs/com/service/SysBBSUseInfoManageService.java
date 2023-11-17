package ko.co.sonsystem.system.bbs.com.service;

import java.util.Map;


/**
 * 게시판 이용정보를 관리하기 위한 서비스 인터페이스 클래스
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
public interface SysBBSUseInfoManageService {

    /**
     * 게시판 사용 정보를 삭제한다.
     * 
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteBBSUseInf(BoardUseInf bdUseInf) throws Exception;

    /**
     * 커뮤니티에 사용되는 게시판 사용정보를 삭제한다.
     * 
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteBBSUseInfByCmmnty(BoardUseInfVO bdUseVO) throws Exception;

    /**
     * 동호회에 사용되는 게시판 사용정보를 삭제한다.
     * 
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteBBSUseInfByClub(BoardUseInfVO bdUseVO) throws Exception;

    /**
     * 커뮤니티에 사용되는 모든 게시판 사용정보를 삭제한다.
     * 
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteAllBBSUseInfByCmmnty(BoardUseInfVO bdUseVO) throws Exception;

    /**
     * 동호회에 사용되는 모든 게시판 사용정보를 삭제한다.
     * 
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteAllBBSUseInfByClub(BoardUseInfVO bdUseVO) throws Exception;

    /**
     * 게시판 사용정보를 등록한다.
     * 
     * @param bdUseInf
     * @throws Exception
     */
    public void insertBBSUseInf(BoardUseInf bdUseInf) throws Exception;

    /**
     * 게시판 사용정보 목록을 조회한다.
     * 
     * @param bdUseVO
     * @return
     * @throws Exception
     */
    public Map<String, Object> selectBBSUseInfs(BoardUseInfVO bdUseVO) throws Exception;

    /**
     * 게시판 사용정보를 수정한다.
     * 
     * @param bdUseInf
     * @throws Exception
     */
    public void updateBBSUseInf(BoardUseInf bdUseInf) throws Exception;

    /**
     * 게시판 사용정보에 대한 상세정보를 조회한다.
     * 
     * @param bdUseVO
     * @return
     * @throws Exception
     */
    public BoardUseInfVO selectBBSUseInf(BoardUseInfVO bdUseVO) throws Exception;

    /**
     * 게시판에 대한 사용정보를 삭제한다.
     * 
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteBBSUseInfByBoardId(BoardUseInf bdUseInf) throws Exception;

    /**
     * 커뮤니티, 동호회에 사용되는 게시판 사용정보에 대한 목록을 조회한다.
     * 
     * @param bdUseVO
     * @return
     * @throws Exception
     */
    public Map<String, Object> selectBBSUseInfsByTrget(BoardUseInfVO bdUseVO) throws Exception;

    /**
     * 커뮤니티, 동호회에 사용되는 게시판 사용정보를 수정한다.
     * 
     * @param bdUseInf
     * @throws Exception
     */
    public void updateBBSUseInfByTrget(BoardUseInf bdUseInf) throws Exception;

}
