package ko.co.sonsystem.system.program.service;

/**
 * 프로그램목록 관리 생성을 위한 모델 클래스를 정의한다.
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

public class ProgrmManage {

	public String getProgrmDc() {
		return progrmDc;
	}
	public void setProgrmDc(String progrmDc) {
		this.progrmDc = progrmDc;
	}
	public String getProgrmFileNm() {
		return progrmFileNm;
	}
	public void setProgrmFileNm(String progrmFileNm) {
		this.progrmFileNm = progrmFileNm;
	}
	public String getProgrmKoreanNm() {
		return progrmKoreanNm;
	}
	public void setProgrmKoreanNm(String progrmKoreanNm) {
		this.progrmKoreanNm = progrmKoreanNm;
	}
	public String getProgrmStrePath() {
		return progrmStrePath;
	}
	public void setProgrmStrePath(String progrmStrePath) {
		this.progrmStrePath = progrmStrePath;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String url) {
		URL = url;
	}
	/**
	 * 프로그램설명
	 */
	private String progrmDc;
	/**
	 * 프로그램파일명
	 */
	private String progrmFileNm;
	/**
	 * 프로그램한글명
	 */
	private String progrmKoreanNm;
	/**
	 * 프로그램저장경로
	 */
	private String progrmStrePath;
	/**
	 * URL
	 */
	private String URL;
}