//brute force implementation, first match, all matches, case-sensitive (can easily be altered)
public class StringMatching {
    public static void main(String[] args){
        System.out.println("""
                [STRING MATCHING]
                Below is the sample text to be scanned:
                
                 To the Extraordinary.
                  
                  You can be in an ordinary role, but what makes you 'extraordinary' is what you do in your daily job to
                  drive improvement, make a difference that matters, contribute towards excellence, and inspire everyone
                  around you by creating an example with yourself to be followed.
                  
                  It is not always easy, as no one will give you recognition, or promotion, or a word of encouragement.
                  However you know you surpassed all of that, after all, the hardest competitor we ever have in our
                  lives is truly ourselves, surpassing the standards that we established for ourselves in past, making
                  little improvements in the processes that we set, finding ways to make differences in what everyone
                  else does.
                  
                  Everyone looks at you, wondering why they never ever thought of that simple little idea (or never had
                  the courage to do it), or how come they could not do what you do at your age, or within certain
                  timeframe (and yet you are open to constructive feedback from those who never did it themselves) and
                  continue to strive for improvements. You should know that your work is outstanding, and you need no
                  one's confirmation or recognition to be extraordinary.
                  
                  You can make a difference all the way from frontline to the back office operations, as a sales rep
                  facing the customers every single day, every single hour, how the work you do differentiates you
                  from rest of the sales reps (competition) who visit the same customers you visit. And, at the back
                  office, what makes a difference is the fantastic operational support you provide, or the customer
                  service, or how do the processes you deploy and improve everyday, how they enhance efficiency, and
                  how all that reflects through a chain-reaction to the frontline.
                  
                  When you are at a middle management level, you carry a very important mission of being that bridge
                  between the executive management and the field staff. With this objective, you can develop those who
                  are good to be extraordinary as well.
                  
                  Lastly, as senior leaders, the expectation from you is even higher as you are in no ordinary role in
                  the first place, you should be expected to perform at extraordinary levels at all times. You need to
                  have a grasp of knowledge and details in order to come up with vision and strategy. You need to
                  constantly think how you can lead by example, inspire everyone you lead, and win the war against your
                  competition, and create new opportunities for your company. I remembered a VP from my previous pharma
                  company as a role model, who used to lead the entire APAC Regional Marketing Team, he was extremely
                  impressive, he may not know every single answer and detail, but he always listened, analyzed,
                  reasoned, and gave directions. He also took every effort to have team meetings every month, and gave
                  everyone feedback despite the little time he had together. He inspired me and everyone else in the
                  team to be the best in whatever we were responsible for, and contribute towards a common larger goal.
                  
                  Strive for Excellence and achieve greatness. If you want to work on something, you should always do
                  your very best. You should expect nothing less than extraordinary from yourself.
                  
                  -Lim Yi Hui
                  """);
        String text= """
                To the Extraordinary.
                                 \s
                                  You can be in an ordinary role, but what makes you 'extraordinary' is what you do in your daily job to
                                  drive improvement, make a difference that matters, contribute towards excellence, and inspire everyone\s
                                  around you by creating an example with yourself to be followed.
                                 \s
                                  It is not always easy, as no one will give you recognition, or promotion, or a word of encouragement.\s
                                  However you know you surpassed all of that, after all, the hardest competitor we ever have in our\s
                                  lives is truly ourselves, surpassing the standards that we established for ourselves in past, making\s
                                  little improvements in the processes that we set, finding ways to make differences in what everyone\s
                                  else does.
                                 \s
                                  Everyone looks at you, wondering why they never ever thought of that simple little idea (or never had\s
                                  the courage to do it), or how come they could not do what you do at your age, or within certain\s
                                  timeframe (and yet you are open to constructive feedback from those who never did it themselves) and\s
                                  continue to strive for improvements. You should know that your work is outstanding, and you need no\s
                                  one's confirmation or recognition to be extraordinary.
                                 \s
                                  You can make a difference all the way from frontline to the back office operations, as a sales rep\s
                                  facing the customers every single day, every single hour, how the work you do differentiates you\s
                                  from rest of the sales reps (competition) who visit the same customers you visit. And, at the back\s
                                  office, what makes a difference is the fantastic operational support you provide, or the customer\s
                                  service, or how do the processes you deploy and improve everyday, how they enhance efficiency, and\s
                                  how all that reflects through a chain-reaction to the frontline.
                                 \s
                                  When you are at a middle management level, you carry a very important mission of being that bridge\s
                                  between the executive management and the field staff. With this objective, you can develop those who\s
                                  are good to be extraordinary as well.
                                 \s
                                  Lastly, as senior leaders, the expectation from you is even higher as you are in no ordinary role in\s
                                  the first place, you should be expected to perform at extraordinary levels at all times. You need to\s
                                  have a grasp of knowledge and details in order to come up with vision and strategy. You need to\s
                                  constantly think how you can lead by example, inspire everyone you lead, and win the war against your\s
                                  competition, and create new opportunities for your company. I remembered a VP from my previous pharma\s
                                  company as a role model, who used to lead the entire APAC Regional Marketing Team, he was extremely\s
                                  impressive, he may not know every single answer and detail, but he always listened, analyzed,\s
                                  reasoned, and gave directions. He also took every effort to have team meetings every month, and gave\s
                                  everyone feedback despite the little time he had together. He inspired me and everyone else in the\s
                                  team to be the best in whatever we were responsible for, and contribute towards a common larger goal.
                                 \s
                                  Strive for Excellence and achieve greatness. If you want to work on something, you should always do\s
                                  your very best. You should expect nothing less than extraordinary from yourself.
                                 \s
                                  -Lim Yi Hui""";
        String key="Excellence";
        System.out.println("The keyword we are looking for is: "+key);
        StringMatching Test=new StringMatching();
        Test.firstMatch(text,key);
        Test.allMatches(text,key);
    }
    StringMatching(){
        //default constructor
    }
    void firstMatch(String text,String key){
        char[] textArray=text.toCharArray();
        char[] keyArray=key.toCharArray();
        boolean found=false;
        for(int i=0;i< textArray.length- keyArray.length;i++){
            int j=0;
            do{
                j=j+1;
            }while(j< keyArray.length && keyArray[j]==textArray[i+j]);
            if(j== keyArray.length){
                System.out.println("The target's first match is found between index "+(i)+" and "+(i+j)+" in the text.");
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("The keyword is NOT found in the text.");
        }
    }
    void allMatches(String text, String key){
        char[] textArray=text.toCharArray();
        char[] keyArray=key.toCharArray();
        boolean found=false;
        for(int i=0;i< textArray.length- keyArray.length;i++){
            int j=0;
            do{
                j=j+1;
            }while(j< keyArray.length && keyArray[j]==textArray[i+j]);
            if(j== keyArray.length){
                System.out.println("The target is found between index "+(i)+" and "+(i+j)+" in the text.");
                found=true;
            }
        }
        if(!found){
            System.out.println("The keyword is NOT found in the text.");
        }
    }

}
