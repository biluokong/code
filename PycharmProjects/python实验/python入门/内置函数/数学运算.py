# 绝对值：abs(num)
print(abs(-234))

# 四舍五入，对浮点数进行近似取值，保留几位小数：round(x,n)
# （不是完全按四舍五入取值，也可能四舍六入五成双来取值。取值结果和python版本有关，也和浮点数的精度有关）
# x——需要取近似值的数值；n——保留的小数位（默认为0）；返回浮点数x的近似值
print(round(3.66))
print(round(2.583745, 2))
print(round(1.24, 1))

# 求指数：pow(x, y, z)
# 返回x的y次方；z——对结果求z的模，即x^y%z
print(3 ** 3)
print(pow(3, 3))
print(pow(3, 3, 4))

# 求商和余数：divmod(a, b)
# 返回一个包含商和余数的元组（a//b, a%b）
print(divmod(3, 5))

# 求最大值：max(x, y, z...)
# 返回给定参数中的最大值
print(max(1, 5, 5, 24, 2, 3))
print(max([12, 4, 534, 4, 34]))
print(max((1, 3, 4, 4, 2)))
print(max({"name": "李四", "age": "12", "nc": "哈哈"}))  # 按字典顺序取最后面的，比较key值，一位一位字母的比较。

# 求和：sum(iterable[, start])
# iterable——可迭代对象，如：列表、元组、集合；start——指定相加的参数，没有默认为0
print(sum(range(50), 3))
print(sum(range(50)))

# 执行字符串表达式，并返回表达式的值：eval(expression[, globals[, locals]])
# expression——表达式；globals——变量作用域，全局命名空间，如果被提供，则必须是一个字典对象；locals——变量作用域，局部命名空间，可以是任何映射对象

a, b, c = 1, 2, 3
print('动态执行的函数{}'.format(eval('a + b + c')))
print('动态执行的函数{}'.format(a + b + c))


def TestFun():
    print("我执行了吗")


eval('TestFun()')   # 要带括号，不能不知道是函数
print(eval('a + b + c', {'c': 3, 'a': 1, 'b': 3}))
print(eval('a + b + c'))
print(eval('a + b + c', {'c': 3, 'a': 1, 'b': 3}, {'a': 2}))

