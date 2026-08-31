package prorammers.level2;

import java.util.ArrayList;
import java.util.List;

public class forkliftAndCrane {
    private int rows;
    private int cols;
    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        rows = storage.length;
        cols = storage[0].length();
        char[][] warehouse = new char[rows][cols];
        for (int row = 0; row < rows; row++) warehouse[row] = storage[row].toCharArray();

        for (String request : requests) {
            char target = request.charAt(0);
            // 크레인
            if (request.length() == 2) removeAll(warehouse, target);
            // 지게차
            else removeAccessible(warehouse, target);
        }
        return countContainers(warehouse);
    }

     //해당 종류의 컨테이너를 전부 제거한다.
    private void removeAll(char[][] warehouse, char target) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (warehouse[row][col] == target) {
                    warehouse[row][col] = '.';
                }
            }
        }
    }

    //현재 외부에서 접근 가능한 target 컨테이너만 제거한다.
    private void removeAccessible(char[][] warehouse, char target) {
        boolean[][] outsideArea = findOutsideArea(warehouse);
        List<int[]> removeList = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (warehouse[row][col] != target) {
                    continue;
                }
                if (isAccessible(row, col, outsideArea)) {
                    removeList.add(new int[]{row, col});
                }
            }
        }
        // 현재 요청에서 제거할 컨테이너를 모두 찾은 뒤 한꺼번에 제거
        for (int[] position : removeList) {
            int row = position[0];
            int col = position[1];
            warehouse[row][col] = '.';
        }
    }

    //외부와 연결되어 있는 빈 공간을 찾기. true: 외부에서 빈 공간을 따라 접근할 수 있는 위치
    private boolean[][] findOutsideArea(char[][] warehouse) {
        boolean[][] visited = new boolean[rows][cols];
        //위 / 아래 테두리
        for (int col = 0; col < cols; col++) {
            if (warehouse[0][col] == '.') dfs(0, col, warehouse, visited);
            if (warehouse[rows - 1][col] == '.') dfs(rows - 1, col, warehouse, visited);
        }
        //왼쪽 / 오른쪽 테두리
        for (int row = 0; row < rows; row++) {
            if (warehouse[row][0] == '.') dfs(row, 0, warehouse, visited);
            if (warehouse[row][cols - 1] == '.') dfs(row, cols - 1, warehouse, visited);
        }
        return visited;
    }

    //외부와 연결된 빈 공간 DFS
    private void dfs(int row, int col, char[][] warehouse, boolean[][] visited) {
        //범위를 벗어났다면 이동 불가.
        if (row < 0 || row >= rows || col < 0 || col >= cols) return;
        // 방문한 곳은 지나갈 수 없음.
        if (visited[row][col]) return;
        // 컨테이너가 존재하는 곳은 지나갈 수 없음.
        if (warehouse[row][col] != '.') return;
        visited[row][col] = true;
        for (int direction = 0; direction < 4; direction++) {
            int nextRow = row + dr[direction];
            int nextCol = col + dc[direction];
            dfs(nextRow, nextCol, warehouse, visited);
        }
    }

    //해당 컨테이너를 지게차로 접근할 수 있는지 판단.
    private boolean isAccessible(int row, int col, boolean[][] outsideArea) {
        // 가장자리 컨테이너는 외부에서 직접 접근.
        if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1) return true;
        // 상하좌우 중 외부와 연결된 빈 공간이 존재하는지 확인
        for (int direction = 0; direction < 4; direction++) {
            int nextRow = row + dr[direction];
            int nextCol = col + dc[direction];
            if (outsideArea[nextRow][nextCol]) {
                return true;
            }
        }
        return false;
    }

    //남은 컨테이너 개수 계산
    private int countContainers(char[][] warehouse) {
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (warehouse[row][col] != '.') count++;
            }
        }
        return count;
    }
}
