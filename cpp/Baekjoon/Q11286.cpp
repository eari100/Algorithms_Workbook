#include<iostream>

using namespace std;

/**
 * @source: https://www.acmicpc.net/problem/11286 (절댓값 힙)
 * @classification: priority queue
 * @문제 푼 날짜 (자력으로 풂?): 25.02.01 (O)
 **/
int q[100'000];
int heap_size = 0;

int get_left_child_index(int root)
{
  return root * 2 + 1;
}

int get_right_child_index(int root)
{
  return root * 2 + 2;
}

int get_parent_index(int child)
{
  return (child - 1) / 2;
}

void swap(int a, int b)
{
  int temp = q[a];
  q[a] = q[b];
  q[b] = temp;
}

void add(int x)
{
  ++heap_size;
  q[heap_size-1] = x;
  int child_index = heap_size-1;

  while(true)
  {
    int parent_index = get_parent_index(child_index);

    if(child_index == parent_index || parent_index == -1)
    {
       break;
    }

    if(abs(q[parent_index]) > abs(q[child_index]))
    {
      swap(child_index, parent_index);
      child_index = parent_index;
    }
    else if (abs(q[parent_index]) == abs(q[child_index]))
    {
      if(q[parent_index] > q[child_index])
      {
        swap(child_index, parent_index);
        child_index = parent_index;
      }
      else
      {
        break;
      }
    }
    else
    {
      break;
    }
  }
}

int poll()
{
  if (heap_size == 0)
  {
    return 0;
  }

  int parent_index = 0, root = q[0];

  if(heap_size > 0)
  {
    q[parent_index] = q[heap_size-1];
    --heap_size;

    while(true)
    {
      int left_child_index = get_left_child_index(parent_index);

      if(heap_size <= left_child_index)
      {
        break;
      }

      int right_child_index = get_right_child_index(parent_index);
      int compare_index;

      if (heap_size <= right_child_index)
      {
        compare_index = left_child_index;
      }
      else
      {
        if (abs(q[left_child_index]) == abs(q[right_child_index]))
        {
          if (q[left_child_index] > q[right_child_index])
          {
            compare_index = right_child_index;
          }
          else
          {
            compare_index = left_child_index;
          }
        }
        else if (abs(q[left_child_index]) > abs(q[right_child_index]))
        {
          compare_index = right_child_index;
        }
        else if (abs(q[left_child_index]) < abs(q[right_child_index]))
        {
          compare_index = left_child_index;
        }
      }

      if(abs(q[parent_index]) > abs(q[compare_index]))
	  {
        swap(parent_index, compare_index);
        parent_index = compare_index;
        continue;
	  }
      else if(abs(q[parent_index]) == abs(q[compare_index]))
      {
        if(q[parent_index] > q[compare_index])
        {
          swap(parent_index, compare_index);
          parent_index = compare_index;
          continue;
        }
      }

      break;
	}
  }

  return root;
}

int main()
{
  int n, x;
  cin >> n;

  while(n-- > 0)
  {
    cin >> x;

    if(x == 0)
    {
      cout << poll() << '\n';
    }
    else
    {
      add(x);
    }
  }
}