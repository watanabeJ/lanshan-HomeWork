package day2.demo01;

import java.util.Stack;

public class Calculator {


        public static String solve(String expression){

            double sum=0,flag=0;
            int top=-1;
            double[] stack1 =  new double[100];
            Stack<Character> stack2 = new Stack<Character>();

            for(int i=0 ; i<expression.length(); i++){
                char p = expression.charAt(i);
                flag = sum = 0;
                if(p >= '0' && p <= '9'){
                    while(true){
                        p = expression.charAt(i);
                        if(p == '.') flag = 0.1;
                        else {
                            if(flag == 0) sum = sum*10+(p-'0');
                            else {
                                sum += ((p-'0')*flag);
                                flag *= 0.1;
                            }
                        }
                        if(i+1<expression.length()&&((expression.charAt(i+1)>='0'&&expression.charAt(i+1)<='9')||expression.charAt(i+1)=='.')) i++;
                        else {
                            stack1[++top]=sum;
                            break;
                        }
                    }
                }
                else {
                    if(p=='(') stack2.push(p);
                    else if(p == '*' || p == '/') {
                        while(stack2.size()>0 && (stack2.peek()=='*'||stack2.peek()=='/')) {
                            double temp = compute(stack1[top--],stack1[top--],stack2.pop());
                            stack1[++top] = temp;
                        }
                        stack2.push(p);
                    }
                    else if(p=='+'||p=='-') {
                        while(stack2.size()>0&&stack2.peek()!='(') {
                            double temp=compute(stack1[top--],stack1[top--],stack2.pop());
                            stack1[++top]=temp;
                        }
                        stack2.push(p);
                    }
                    else if(p==')') {
                        while(stack2.size()>0&&stack2.peek()!='(') {
                            double temp = compute(stack1[top--],stack1[top--],stack2.pop());
                            stack1[++top] = temp;
                        }
                        stack2.pop();
                    }
                }
            }


            while(stack2.size()>0) {
                double temp=compute(stack1[top--],stack1[top--],stack2.pop());
                stack1[++top] = temp;
            }
            return "" + stack1[top];
        }

        public static double compute(double a,double b, char p) {
            double sum = 0;
            if(p=='+') {
                sum = b+a;
            }else if(p=='-') {
                sum = b-a;
            }else if(p=='*') {
                sum = b*a;
            }else if(p=='/') {
                sum = b/a;
            }
            return sum;
        }

    }

