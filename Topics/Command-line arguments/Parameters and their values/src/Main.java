
class Problem {
    public static void main(String[] args) {

        for (int i = 0; i < args.length; i += 2) {
            StringBuilder output = new StringBuilder();
            output.append(args[i]).append("=").append(args[i + 1]);
            System.out.println(output);
        }
    }
}