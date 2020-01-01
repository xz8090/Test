#include<iostream.h>
#include<stdlib.h>
#include<time.h>
double _uniform(double min, double max, long int *seed) {
    double t = 0;
    *seed = 2045 * (*seed) + 1;
    *seed = *seed - (*seed / 1048576) * 1048576;
    t = (*seed) / 1048576.0;
    t = min + (max - min) * t;
    return t;
}
 
/*
 *均匀分布随机函数产生随机数
*/
long int Uniform(double min, double max) {
    long int s = 0;
    double r = 0;
 
    s = rand();
    r = _uniform(min, max, &s);
 
    return ((long int)r);
}
 
//算法二
double AverageRandom(double min, double max) {
    int minInteger = (int)(min * 10000);
    int maxInteger = (int)(max * 10000);
    int randInteger = rand() * rand();
    int diffInteger = maxInteger - minInteger;
    int resultInteger = randInteger % diffInteger + minInteger;
 
    return (resultInteger/10000.0);
}
int main()
{
  cout << 1 << endl;

  return 0;
}
