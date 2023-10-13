import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class MapTest{

public static void main(String[] args){
	Map<String, Object> map = new HashMap<>();
  map.put("DEPTNO", 10);
	map.put("DNAME", "영업부");
	map.put("LOC", "부산");//[{DEPTNO, 10}, {DNAME, 영업부}, {LOC, 부산}]
  Map<String, Object> map2 = new HashMap<>();
  map2.put("DEPTNO", 20);
	map2.put("DNAME", "생산부");
	map2.put("LOC", "제주");
  Set<String> set = map.keySet();
	Object keys[] = set.toArray();
for(int i = 0;i<keys.length;i++) {
			System.out.println(map.get(keys[i]) +"<<<" +keys[i]);
		}//KEY 값만 맵에서 추출
  List<Map<String, Object>> mapList = new ArrayList<>();
  mapList.add(map);
  mapList.add(map2);//위의 map2 배열이 추가됨

  System.out.println(mapList.get(1).get("DEPTNO"));//20
}
}
  
  
