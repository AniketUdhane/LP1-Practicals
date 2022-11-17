package lp1_pr4;

import java.util.Arrays;
class first
{
// Method to allocate memory to
// blocks as per First fit algorithm
static void firstFit(int blockSize[], int m,int processSize[], int n)
{
// Stores block id of the
// block allocated to a process
int allocation[] = new int[n];
// Initially no block is assigned to any process
for (int i = 0; i < allocation.length; i++)
allocation[i] = -1;
// pick each process and find suitable blocks
// according to its size ad assign to it
for (int i = 0; i < n; i++)
{
for (int j = 0; j < m; j++)
{
if (blockSize[j] >= processSize[i])
{
// allocate block j to p[i] process
allocation[i] = j;
// Reduce available memory in this block.
blockSize[j] -= processSize[i];
break;
}
}}
System.out.println("\nProcess No.\tProcess Size\tBlock no.");
for (int i = 0; i < n; i++)
{
System.out.print(" " + (i+1) + "\t\t" +
processSize[i] + "\t\t");
if (allocation[i] != -1)
System.out.print(allocation[i] + 1);
else
System.out.print("Not Allocated");
System.out.println();
}
}
static void bestFit(int blockSize[], int m, int processSize[],
int n)
{
// Stores block id of the block allocated to a
// process
int allocation[] = new int[n];
// Initially no block is assigned to any process
for (int i = 0; i < allocation.length; i++)
allocation[i] = -1;
// pick each process and find suitable blocks
// according to its size ad assign to it
for (int i=0; i<n; i++)
{
// Find the best fit block for current process
int bestIdx = -1;
for (int j=0; j<m; j++)
{
if (blockSize[j] >= processSize[i])
{
if (bestIdx == -1)
bestIdx = j;
else if (blockSize[bestIdx] > blockSize[j])
bestIdx = j;
}
}
// If we could find a block for current process
if (bestIdx != -1)
{
// allocate block j to p[i] process
allocation[i] = bestIdx;
// Reduce available memory in this block.
blockSize[bestIdx] -= processSize[i];
}
}
System.out.println("\nProcess No.\tProcess Size\tBlock no.");
for (int i = 0; i < n; i++)
{
System.out.print(" " + (i+1) + "\t\t" + processSize[i] + "\t\t");
if (allocation[i] != -1)
System.out.print(allocation[i] + 1);
else
System.out.print("Not Allocated");
System.out.println();
}
}
static void worstFit(int blockSize[], int m, int processSize[],
int n)
{
// Stores block id of the block allocated to a
// process
int allocation[] = new int[n];
// Initially no block is assigned to any process
for (int i = 0; i < allocation.length; i++)
allocation[i] = -1;
// pick each process and find suitable blocks
// according to its size ad assign to it
for (int i=0; i<n; i++)
{
// Find the best fit block for current process
int wstIdx = -1;
for (int j=0; j<m; j++)
{
if (blockSize[j] >= processSize[i])
{
if (wstIdx == -1)
wstIdx = j;
else if (blockSize[wstIdx] < blockSize[j])
wstIdx = j;
}
}
// If we could find a block for current process
if (wstIdx != -1)
{
// allocate block j to p[i] process
allocation[i] = wstIdx;
// Reduce available memory in this block.
blockSize[wstIdx] -= processSize[i];
}
}
System.out.println("\nProcess No.\tProcess Size\tBlock no.");
for (int i = 0; i < n; i++)
{
System.out.print(" " + (i+1) + "\t\t" + processSize[i] + "\t\t");
if (allocation[i] != -1)
System.out.print(allocation[i] + 1);
else
System.out.print("Not Allocated");
System.out.println();
}
}
static void NextFit(int blockSize1[], int m1, int processSize1[], int n1) {
// Stores block id of the block allocated to a
// process
int allocation[] = new int[n1], j = 0;
// Initially no block is assigned to any process
Arrays.fill(allocation, -1);
// pick each process and find suitable blocks
// according to its size ad assign to it
for (int i = 0; i < n1; i++) {
// Do not start from beginning
int count =0;
while (j < m1) {
count++; //makes sure that for every process we traverse through entire
//array maximum once only.This avoids the problem of going into infinite loop if memory is
//not available
if (blockSize1[j] >= processSize1[i]) {
// allocate block j to p[i] process
allocation[i] = j;
// Reduce available memory in this block.
blockSize1[j] -= processSize1[i];
break;
}
// mod m will help in traversing the blocks from
// starting block after we reach the end.
j = (j + 1) % m1;
}
}
System.out.print("\nProcess No.\tProcess Size\tBlock no.\n");
for (int i = 0; i < n1; i++) {
System.out.print( i + 1 + "\t\t" + processSize1[i]
+ "\t\t");
if (allocation[i] != -1) {
System.out.print(allocation[i] + 1);
} else {
System.out.print("Not Allocated");
}
System.out.println("");
}
}
// Driver Code
public static void main(String[] args)
{
System.out.println("....First Fit....");
int blockSize[] = {100, 500, 200, 300, 600};
int processSize[] = {212, 417, 112, 426};
int m = blockSize.length;
int n = processSize.length;
firstFit(blockSize, m, processSize, n);
/* int blockSize[] = {100, 500, 200, 300, 600};
int processSize[] = {212, 417, 112, 426};
int m = blockSize.length;
int n = processSize.length;*/
System.out.println(" ");
System.out.println("....Best Fit....");
bestFit(blockSize, m, processSize, n);
System.out.println(" ");
System.out.println("....Worst Fit....");
worstFit(blockSize, m, processSize, n);
System.out.println(" ");
System.out.println("....Next Fit....");
int blockSize1[] = {5, 10, 20};
int processSize1[] = {10, 20, 5};
int m1 = blockSize1.length;
int n1 = processSize1.length;
NextFit(blockSize1, m1, processSize1, n1);
}
}
