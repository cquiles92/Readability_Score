
class Problem {
    public static void main(String[] args) {
        int position = -1;

        for (int i = 0; i < args.length; i++) {
            if ("test".equals(args[i])) {
                position = i;
                break;
            }
        }
        System.out.println(position);
    }
}