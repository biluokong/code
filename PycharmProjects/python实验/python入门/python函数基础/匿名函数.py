m = lambda num1, num2: print(12)
print(m)  # 输出了匿名函数的地址
print(m(1, 2))  # 执行了匿名函数的输出语句，此输出语句则输出了none

n = lambda num1, num2: num1 + num2
print(n)  # 输出了匿名函数的地址
print(n(12, 4))  # 输出了匿名函数自动返回的语句执行的结果：16

print((lambda num1, num2: num1 * num2)(2, 4))
