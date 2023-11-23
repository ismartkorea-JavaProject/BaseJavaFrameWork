package ko.co.sonsystem.mng.cmm.zip.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.egovframe.rte.fdl.excel.EgovExcelMapping;
import org.egovframe.rte.fdl.excel.util.EgovExcelUtil;

import ko.co.sonsystem.mng.cmm.zip.service.Zip;

/**
 *
 * Excel 우편번호 매핑 클래스
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
public class SysCcmExcelZipMapping extends EgovExcelMapping {

	/**
	 * 우편번호 엑셀파일 맵핑
	 */
	@Override
	public Object mappingColumn(Row row) {
		Cell cell0 = row.getCell((short) 0);
    	Cell cell1 = row.getCell((short) 1);
    	Cell cell2 = row.getCell((short) 2);
    	Cell cell3 = row.getCell((short) 3);
    	Cell cell4 = row.getCell((short) 4);
    	Cell cell5 = row.getCell((short) 5);
    	Cell cell6 = row.getCell((short) 6);
    	Cell cell7 = row.getCell((short) 7);

		Zip vo = new Zip();

		vo.setZip            (EgovExcelUtil.getValue(cell0));
		vo.setSn             (Integer.parseInt(EgovExcelUtil.getValue(cell1)));
		vo.setCtprvnNm       (EgovExcelUtil.getValue(cell2));
		vo.setSignguNm       (EgovExcelUtil.getValue(cell3));
		vo.setEmdNm          (EgovExcelUtil.getValue(cell4));
		vo.setFrstRegisterId (EgovExcelUtil.getValue(cell7));

		if (cell5 != null) {vo.setLiBuldNm   (EgovExcelUtil.getValue(cell5));}
		if (cell6 != null) {vo.setLnbrDongHo (EgovExcelUtil.getValue(cell6));}


		return vo;
	}
}
