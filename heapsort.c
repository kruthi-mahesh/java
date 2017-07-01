#include<stdio.h>
#include<stdlib.h>
#include<math.h>
struct Heap
{
	int a[10],length,heap_size;
};
typedef struct Heap heap;

void display(heap h)
{
	int i;
	for(i=1;i<=h.length;i++)
		printf("%d\t",h.a[i]);
	printf("\n");
}

heap Heapify(heap h,int i)
{
	int l = 2*i;
	int r = 2*i +1;
	int large;
	if(l<=h.heap_size && h.a[l] > h.a[i])
		large = l;
	else
		large = i;
	if(r<=h.heap_size && h.a[r] > h.a[large])
		large = r;
	if(large != i)
	{
		int t = h.a[i];
		h.a[i] = h.a[large];
		h.a[large] = t;
		h = Heapify(h,large);
	}
	return h;
}

heap buildHeap(heap h)
{	
	int i;	
	h.heap_size = h.length;
	for(i=floor(h.length/2);i >= 1;i--)
		h = Heapify(h,i);
	return h;
}

heap extract(heap h)
{
	printf("%d",h.a[1]);
	h.a[1] = h.a[h.heap_size];
	h.heap_size--;
	h = Heapify(h,1);
	return h;
}

heap heapsort(heap h)
{
	h = buildHeap(h);
	int i;
	for(i=h.length;i>=2;i--)
	{
		int t = h.a[i];
		h.a[i] = h.a[1];
		h.a[1] = t;
		h.heap_size--;
		h = Heapify(h,1);
	}
	return h;
}

/*heap change(heap h,int i,int key)
{
	h.a[i] = key;
	h = heapify(h,*/	

void main()
{
	int ch,i,key;
	
	heap h;
	printf("Enter number of elements:\n");
	scanf("%d",&h.length);
	
	for(i=1;i<h.length+1;i++)
		scanf("%d",&h.a[i]);
	while(1)
	{
	
		printf("\nEnter choice:\n1-Build heap\n2-Get max\n3-Change key\n4-Heap sort\n5-Display heap\n6-extract max\n");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1: h = buildHeap(h);
				break;
			case 2: printf("%d\n",h.a[1]);
				break;
			/*case 3:	printf("Enter index and key to be changed");
				scanf("%d %d",&i,&key); 
				h = change(h,i,key);
				break;*/
			case 4: h = heapsort(h);
				break;
			case 5: display(h);
				break;
			case 6: h = extract(h);
				break;
			default: exit(0);
		}
	}
}
	