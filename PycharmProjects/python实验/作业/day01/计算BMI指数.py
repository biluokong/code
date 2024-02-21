
tall = 0
weight = 0
while tall <= 0 or weight <= 0:
    tall = float(input('请输入您的身高：'))
    weight = float(input('请输入您的体重：'))
    if tall <= 0 or weight <= 0:
        print('输入非法，请重新输入。')

BMI = weight / (tall ** 2)  # BMI指数

if BMI < 18.5:
    print('过轻')
elif BMI < 25:
    print('正常')
elif BMI < 28:
    print('过重')
elif BMI < 32:
    print('肥胖')
else:
    print('严重肥胖')