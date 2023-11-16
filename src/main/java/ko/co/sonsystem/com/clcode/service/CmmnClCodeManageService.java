package ko.co.sonsystem.com.clcode.service;

import java.util.List;

/**
*
* 공통분류코드에 관한 서비스 인터페이스 클래스를 정의한다
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
public interface CmmnClCodeManageService {

	/**
	 * 공통분류코드를 삭제한다.
	 * @param cmmnClCode
	 * @throws Exception
	 */
	void deleteCmmnClCode(CmmnClCode cmmnClCode) throws Exception;

	/**
	 * 공통분류코드를 등록한다.
	 * @param cmmnClCode
	 * @throws Exception
	 */
	void insertCmmnClCode(CmmnClCode cmmnClCode) throws Exception;

	/**
	 * 공통분류코드 상세항목을 조회한다.
	 * @param cmmnClCode
	 * @return CmmnClCode(공통분류코드)
	 * @throws Exception
	 */
	 CmmnClCode selectCmmnClCodeDetail(CmmnClCode cmmnClCode) throws Exception;

	/**
	 * 공통분류코드 목록을 조회한다.
	 * @param searchVO
	 * @return List(공통분류코드 목록)
	 * @throws Exception
	 */
	List<?> selectCmmnClCodeList(CmmnClCodeVO searchVO) throws Exception;

   /**
	 * 공통분류코드 총 갯수를 조회한다.
    * @param searchVO
    * @return int(공통분류코드 총 갯수)
    */
   int selectCmmnClCodeListTotCnt(CmmnClCodeVO searchVO) throws Exception;

	/**
	 * 공통분류코드를 수정한다.
	 * @param cmmnClCode
	 * @throws Exception
	 */
	void updateCmmnClCode(CmmnClCode cmmnClCode) throws Exception;

}
