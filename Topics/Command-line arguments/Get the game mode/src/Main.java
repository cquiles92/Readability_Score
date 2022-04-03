class Problem {
    public static void main(String[] args) {
        String output = "default";
        for (int i = 0; i < args.length; i += 2) {
            if ("mode".equals(args[i])) {
                output = args[i + 1];
                break;
            }
        }
        System.out.println(output);
    }
}
