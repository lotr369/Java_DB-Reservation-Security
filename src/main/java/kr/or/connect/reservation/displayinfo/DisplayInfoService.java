package kr.or.connect.reservation.displayinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisplayInfoService {
	
	@Autowired
	DisplayInfoDao displayInfoDao;
	private int limit=4;

	//카테고리 아이디가 0또는 없을 경우 전체 조회
	public Map<String, Object> getDisplayInfos(int categoryId,int start) {
		Map<String, Object> map=new HashMap<>();
		if(categoryId<=0) {
			//전체 가져 오기
			List<DisplayInfo> list=displayInfoDao.getDisplayInfos();
			// 해당 카테고리의 전시 상품 수
			map.put("totalCount", list.size());
			// 읽어온 전시 상품 수
			map.put("productCount", list.size());
			// 전시 상품 정보
			map.put("products",list);
		}else {
			//카테고리 아이디가 있을 때
			List<DisplayInfo> list=displayInfoDao.getDisplayInfosLimit(categoryId, start, limit);
			// 해당 카테고리의 전시 상품 수
			int categoriesSize=displayInfoDao.getDisplayInfosCnt(categoryId);
			map.put("totalCount", categoriesSize);
			// 읽어온 전시 상품 수
			map.put("productCount", list.size());
			// 전시 상품 정보
			map.put("products",list);
		}
		return map;
	}
	
	//전시 정보 구하기
	public Map<String, Object> getDisplayInfo(int displayId) {
		Map<String, Object> map=new HashMap<>();
		map.put("product",displayInfoDao.getDisplayInfo(displayId));
		map.put("productImages",displayInfoDao.getProductImages(displayId));
		map.put("displayInfoImages",displayInfoDao.getDisplayInfoImages(displayId));
		map.put("avgScore",displayInfoDao.getAvgScore(displayId));
		map.put("productPrices",displayInfoDao.getProductPrices(displayId));
		return map;
	}
}
