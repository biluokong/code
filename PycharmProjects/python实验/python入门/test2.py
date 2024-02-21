import cv2

# 读取图像
img = cv2.imread(r"D:\Download\project1.bmp")

# 获取图像宽高
height, width = img.shape[:2]

left_img = img[:, :int(width/2)]
top_img = img[:int(height/2), :]

# 转换为灰度图像
gray_img = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

# 进行边缘检测
edge_img = cv2.Canny(gray_img, 100, 200)

# 获取轮廓
contours, hierarchy = cv2.findContours(edge_img, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)

# 获取包含所有轮廓的最小矩形
rect = cv2.boundingRect(contours[0])

# 在原始图像中用红色矩形框选出目标区域
cv2.rectangle(img, (rect[0], rect[1]), (rect[0]+rect[2], rect[1]+rect[3]), (0, 0, 255), 2)

# 显示结果图像
cv2.imshow('Left_Image', left_img)
cv2.imshow('Top_Image', top_img)
cv2.imshow('Selected_Image', img)
cv2.waitKey(0)
cv2.destroyAllWindows()