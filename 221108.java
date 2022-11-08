public class Application {
    public static void main(String[] args) throws IOException {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println("숫자 야구 게임을 시작합니다. ");

        int startOrEnd = 1;

        while (startOrEnd != 2) {
            System.out.print("숫자를 입력해주세요 : ");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            int inputNumber = Integer.parseInt(input.readLine());
            int[] inputNumbers = new int[3];

            inputNumbers[0] = inputNumber / 100;
            inputNumbers[1] = (inputNumber / 10) % 10;
            inputNumbers[2] = inputNumber % 10;

            int ball = 0;
            int strike = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (inputNumbers[i] == computer.get(j)) {
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
            }

            if (strike == 3) {
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                BufferedReader inputStartOrEnd = new BufferedReader(new InputStreamReader(System.in));

                if (Integer.parseInt(inputStartOrEnd.readLine()) == 2) {
                    startOrEnd = 2;
                    continue;
                }
            } else {
                if (ball == 0 && strike == 0) {
                    System.out.println("낫싱");

                } else if (ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else if (strike == 0) {
                    System.out.println(ball + "볼");
                } else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }
            }
        }
    }
}
