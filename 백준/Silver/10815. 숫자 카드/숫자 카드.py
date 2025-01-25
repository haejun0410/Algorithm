n = int(input())
cards = list(map(int,input().split()))
numTarget = int(input())
target = list(map(int,input().split()))
cards.sort()

def binSearch(li,t):
	l = 0
	r = len(li)-1
	while l <= r:
		mid = (l+r)//2
		if t == li[mid]:
			return 1
		elif t > li[mid]:
			l = mid+1
		else:
			r = mid - 1
	return 0
for i in target:
	print(binSearch(cards,i),end = " ")
	