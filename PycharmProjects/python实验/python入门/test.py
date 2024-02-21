import cv2
from skimage import morphology, io
import matplotlib.pyplot as plt

# 读取原图片
img1 = cv2.imread("D:\\Download\\vas0.png")
cv2.imshow("img1", img1)
# 阈值分割
img2 = cv2.adaptiveThreshold(cv2.cvtColor(img1, cv2.COLOR_BGR2GRAY), 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY,
                             15, 3)  # 自适应阈值分割
cv2.imshow('img2', img2)
# 图像反色
h, w = img2.shape
img3 = img2.copy()
for i in range(h):
    for j in range(w):
        img3[i, j] = 255 - img3[i, j]
cv2.imshow('img3', img3)
# 图像扩展
img4 = cv2.copyMakeBorder(img3, 1, 1, 1, 1, cv2.BORDER_REFLECT)
cv2.imshow('img4', img4)
# 去除小面积区域
contours, hierarch = cv2.findContours(img4, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_NONE)  # 轮廓提取
for i in range(len(contours)):
    area = cv2.contourArea(contours[i])  # 计算轮廓所占面积
    if area < 200:  # 将area小于阈值区域填充背景色，OpenCV读出的是BGR值
        cv2.drawContours(img4, [contours[i]], -1, (0, 0, 0), thickness=-1)  # 原始图片背景BGR值为(0,0,0)
cv2.imshow('img5', img4)
# 进一步细化，去除较小面积区域，保留最大连通区域
img5 = img4.copy()
contours1, hierarchy = cv2.findContours(img5, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_NONE)
for i in range(len(contours1)):
    area1 = cv2.contourArea(contours1[i])
    print(area1)
    if area1 == 214.5:
        cv2.drawContours(img5, [contours1[i]], -1, (0, 0, 0), thickness=-1)
    elif area1 == 363.0:
        cv2.drawContours(img5, [contours1[i]], -1, (0, 0, 0), thickness=-1)
cv2.imshow('img6', img5)
# 实施骨架算法
img6 = img5.copy()
cv2.threshold(img6, 80, 1, 0, img6)
img7 = morphology.skeletonize(img6)
plt.imshow(img7, cmap=plt.cm.gray)
plt.axis('off')
plt.show()
# 图像反色
h1, w1 = img7.shape
img8 = img7.copy()
for i in range(h1):
    for j in range(w1):
        img8[i, j] = 1 - img8[i, j]
plt.imshow(img8, cmap=plt.cm.gray)
plt.axis('off')
plt.show()
# 边缘提取
img9 = cv2.Canny(img5, 80, 255)
cv2.imshow("img9", img9)
# 图像反色
h2, w2 = img9.shape
img10 = img9.copy()
for i in range(h2):
    for j in range(w2):
        img10[i, j] = 255 - img10[i, j]
cv2.imshow("img10", img10)
cv2.waitKey(0)
