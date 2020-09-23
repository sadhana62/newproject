#include<iostream>
using namespace std;
class Question
{
private:
    int op;
    int score=0;
public:
    void getque(int num)
    {
        if(num==1)
        {
            cout<<"              1.How many continent are there in World\n";
            cout<<"              1.6\n";
            cout<<"              2.7\n";
            cout<<"              3.8\n";
            cout<<"              4.9\n";
            cin>>op;
            if(op==2)
            {
                score=score+10;
            }
            else
            score=score+0;
        }
         if(num==2)
        {

            cout<<"              2.Grand Central Terminal, Park Avenue, New York is the world\n";
            cout<<"              1.largest railway station\n";
            cout<<"              2.highest railway station\n";
            cout<<"              3.longest railway station\n";
            cout<<"              4.None of the above\n";
            cin>>op;
            if(op==1)
            {
                score=score+10;
            }
            else
            score=score+0;
        }
          if(num==3)
        {

            cout<<"              3.Entomology is the science that studies\n";
            cout<<"              1.Behavior of human beings\n";
            cout<<"              2.Insects\n";
            cout<<"              3.The origin and history of technical and scientific terms\n";
            cout<<"              4.The formation of rocks\n";
            cin>>op;
            if(op==2)
            {
                score=score+10;
            }
            else
            score=score+0;
        }
             if(num==4)
        {

            cout<<"              4.Eritrea, which became the 182nd member of the UN in 1993, is in the continent of\n";
            cout<<"              1.Asia\n";
            cout<<"              2.Africa\n";
            cout<<"              3.Europe\n";
            cout<<"              4.Australia\n";
            cin>>op;
            if(op==2)
            {
                score=score+10;
            }
            else
            score=score+0;
        }
              if(num==5)
        {

            cout<<"              5.Garampani sanctuary is located at\n";
            cout<<"              1.Junagarh, Gujarat\n";
            cout<<"              2.Diphu, Assam\n";
            cout<<"              3.Kohima, Nagaland\n";
            cout<<"              4.Gangtok, Sikkim\n";
            cin>>op;
            if(op==2)
            {
                score=score+10;
            }
            else
            score=score+0;
        }
              if(num==6)
        {

            cout<<"              6.For which of the following disciplines is Nobel Prize awarded?\n";
            cout<<"              1.Physics and Chemistry\n";
            cout<<"              2.Physiology or Medicine\n";
            cout<<"              3.Literature, Peace and Economics\n";
            cout<<"              4.All of the above\n";
            cin>>op;
            if(op==4)
            {
                score=score+10;
            }
            else
            score=score+0;
        }
        if(num==7)
        {

            cout<<"              7.Hitler party which came into power in 1933 is known as\n";
            cout<<"              1.Labour Party\n";
            cout<<"              2.Nazi Party\n";
            cout<<"              3.Ku-Klux-Klan\n";
            cout<<"              4.Democratic Party\n";
            cin>>op;
            if(op==2)
            {
                score=score+10;
            }
            else
            score=score+0;
        }
        if(num==8)
        {

            cout<<"              8.FFC stands for\n";
            cout<<"              1.Foreign Finance Corporation\n";
            cout<<"              2.Film Finance Corporation\n";
            cout<<"              3.Federation of Football Council\n";
            cout<<"              4.None of the above\n";
            cin>>op;
            if(op==2)
            {
                score=score+10;
            }
            else
            score=score+0;
        }
        if(num==9)
        {

            cout<<"              9.Fastest shorthand writer was\n";
            cout<<"              1.Dr. G. D. Bist\n";
            cout<<"              2.J.R.D. Tata\n";
            cout<<"              3.J.M. Tagore\n";
            cout<<"              4.Khudada Khan\n";
            cin>>op;
            if(op==1)
            {
                score=score+10;
            }
            else
            score=score+0;
        }
         if(num==10)
        {

            cout<<"             10.Epsom (England) is the place associated with\n";
            cout<<"              1.Horse racing\n";
            cout<<"              2.Polo\n";
            cout<<"              3.Shooting\n";
            cout<<"              4. Snooker\n";
            cin>>op;
            if(op==1)
            {
                score=score+10;
            }
            else
            score=score+0;
        }

    }
    void result()
    {

        if(score>=70)
        {
            cout<<"CONGRATURATION!!! YOUR ARE PASS AND YOUR SCORE IS "<<score<<endl;
        }
        else
            cout<<"BETTER TRY NEXT TIME your score is "<<score<<endl;
    }
};
int main()
{ cout<<"                               ******************************************************\n";
  cout<<"                               ******************************************************\n";
  cout<<"                               ******************************************************\n";
  cout<<"                               ********************WELCOME TO QIIZ*******************\n";
  cout<<"                               ******************************************************\n";
  cout<<"                               ******************************************************\n";
  cout<<"                               ******************************************************\n";
  cout<<"                               ******************************************************\n";
  cout<<" If you are interested in quiz and want to play than press CONTINUE to play\n";
  string str;
  cin>>str;
  if(( str=="continue")||(str=="CONTINUE"))
  {
        Question obj;
    for(int i=1;i<=10;i++)
    {
        obj.getque(i);
    }
    obj.result();
 cout<<"THANKS FOR YOUR TIME have a nice day@@@@@";
  }
  else
  {

      cout<<"Error:";
  }
}
