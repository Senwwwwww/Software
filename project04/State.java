package B1.code;

// 状态接口
interface State {
    void handle(Character input, StateMachine context);
}

// 状态机上下文类
class StateMachine {
    private State currentState; // 当前状态

    public StateMachine(State initialState) {
        this.currentState = initialState; // 初始化状态
    }

    public void setCurrentState(State state) {
        this.currentState = state; // 设置当前状态
    }

    public void handleInput(Character input) {
        currentState.handle(input, this); // 处理输入字符
    }
}

// 具体状态类：正常状态
class NormalState implements State {
    @Override
    public void handle(Character input, StateMachine context) {
        if (input == '“') {
            // 遇到双引号，进入字符串状态
            context.setCurrentState(new StringState());
        } else {
            // 处理其他字符
            System.out.print(input);
        }
    }
}

// 具体状态类：字符串状态
class StringState implements State {
    @Override
    public void handle(Character input, StateMachine context) {
        if (input == '\\') {
            // 遇到反斜杠，进入转义状态
            context.setCurrentState(new EscapeState());
        } else if (input == '”') {
            // 遇到双引号，返回到正常状态
            context.setCurrentState(new NormalState());
        } else {
            // 在字符串状态下处理其他字符
            System.out.print(input);
        }
    }
}

// 具体状态类：转义状态
class EscapeState implements State {
    @Override
    public void handle(Character input, StateMachine context) {
        // 打印转义字符
        System.out.print(input);
        // 返回字符串状态
        context.setCurrentState(new StringState());
    }
}

// 主类，运行状态机
class StringStateMachine {
    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine(new NormalState());

        // 测试字符串
        String testString = "“一般学习一门编程语言的时候，基本上第一个程序是输出\\\"Hello World!\\\"”";

        for (char ch : testString.toCharArray()) {
            stateMachine.handleInput(ch); // 逐字符处理输入
        }

        // 最终输出换行，表示字符串处理完成
        System.out.println("\n字符串处理完成。");
    }
}
