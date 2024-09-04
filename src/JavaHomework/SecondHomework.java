package JavaHomework;

import java.util.*;

public class SecondHomework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 자료구조 선택
        System.out.print("저장할 자료구조명을 입력합니다. (List / Set / Map 이용하기): ");
        String dataStructure = scanner.nextLine().trim();

        // 자료구조 초기화
        Object dataStructureInstance;
        if (dataStructure.equalsIgnoreCase("List")) {
            dataStructureInstance = new ArrayList<String>();
        } else if (dataStructure.equalsIgnoreCase("Set")) {
            dataStructureInstance = new HashSet<String>();
        } else if (dataStructure.equalsIgnoreCase("Map")) {
            dataStructureInstance = new LinkedHashMap<Integer, String>();
        } else {
            System.out.println("지원하지 않는 자료구조입니다.");
            scanner.close();
            return;
        }

        // 요리 제목 입력
        System.out.print("내가 좋아하는 요리 제목을 입력합니다: ");
        String title = scanner.nextLine().trim();

        // 레시피 입력
        System.out.println("이어서 내가 좋아하는 요리 레시피를 한 문장씩 입력합니다. 입력을 마쳤으면 마지막에 ‘끝’을 입력하세요.");
        int recipeNumber = 1;

        if (dataStructure.equalsIgnoreCase("Map")) {
            LinkedHashMap<Integer, String> map = (LinkedHashMap<Integer, String>) dataStructureInstance;
            while (true) {
                System.out.print("레시피를 입력하세요 (끝 입력으로 종료): ");
                String line = scanner.nextLine().trim();
                if (line.equals("끝")) {
                    break;
                }
                map.put(recipeNumber++, line);
            }
        } else {
            Collection<String> collection = (Collection<String>) dataStructureInstance;
            while (true) {
                System.out.print("레시피를 입력하세요 (끝 입력으로 종료): ");
                String line = scanner.nextLine().trim();
                if (line.equals("끝")) {
                    break;
                }
                collection.add(line);
            }
        }

        // 출력
        System.out.printf("[ %s 으로 저장된 %s ]%n", dataStructure, title);
        if (dataStructure.equalsIgnoreCase("Map")) {
            LinkedHashMap<Integer, String> map = (LinkedHashMap<Integer, String>) dataStructureInstance;
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                System.out.printf("%d. %s%n", entry.getKey(), entry.getValue());
            }
        } else {
            Collection<String> collection = (Collection<String>) dataStructureInstance;
            int number = 1;
            for (String recipe : collection) {
                System.out.printf("%d. %s%n", number++, recipe);
            }
        }

        scanner.close();
    }
}
