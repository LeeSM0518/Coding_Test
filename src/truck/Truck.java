package truck;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Truck {

    // 트럭의 무게와 트럭이 건너간 거리
    static class TruckAndMove {
        int weight;
        int move;

        public TruckAndMove(int weight, int move) {
            this.weight = weight;
            this.move = move;
        }
    }

    static public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int time = 1;
        Stack<TruckAndMove> goneTruck = new Stack<>();
        Queue<TruckAndMove> onBridge = new LinkedList<>();
        int currentWeightSum = 0;
        int truckIndex = 0;


        while (true) {
            // 트럭 전부가 다리를 건넜을 때
            if (goneTruck.size() == truckWeights.length) break;

                // 현재 다리 위에 트럭이 없을 때
            else if (onBridge.size() == 0) {
                TruckAndMove truckAndMove = new TruckAndMove(truckWeights[truckIndex], 0);
                onBridge.add(truckAndMove);
                currentWeightSum += truckAndMove.weight;
                truckIndex++;
            }

            // 현재 다리 위에 트럭이 있고 대기 중인 트럭이 있을 때
            else if (truckIndex < truckWeights.length){

                // 현재 다리 위에 있는 트럭 무게와 새롭게 다리로 진입해야할 트럭의 무게를
                // 더한 값이 다리가 견딜 수 있는 무게보다 크지 않을 때
                if (!(currentWeightSum + truckWeights[truckIndex] > weight)) {
                    TruckAndMove truckAndMove = new TruckAndMove(truckWeights[truckIndex], 0);
                    onBridge.add(truckAndMove);
                    currentWeightSum += truckAndMove.weight;
                    truckIndex++;
                }
            }

            // 트럭이 다리를 1만큼 지나간다
            onBridge.forEach(truck -> {
                truck.move++;
            });

            // 다리 위에 있는 트럭이 움직인 거리가 다리의 길이와 같을때
            if (onBridge.peek().move % bridgeLength == 0) {
                TruckAndMove truckAndMove = onBridge.poll();
                currentWeightSum -= truckAndMove.weight;
                goneTruck.push(truckAndMove);
            }

            time++;
        }

        return time;
    }


    public static void main(String[] args) {
        int bridgeLength = 2;
        int weight = 10;
        int[] truckWeights = new int[]{7, 4, 5, 6};

        System.out.println(solution(bridgeLength, weight, truckWeights));
    }
}