package com.example.chooselife;

public class class_FutureQuestion {
   private int rare, storynum;
   private String question;
   private class_TraitAnswer opta, optb, optc, optd;
   private String qual_skill;
   private String readme;

   public class_FutureQuestion()
   {
      rare = 0;
      storynum = 0;
      question = "";
   }

   public class_FutureQuestion(int vrare, int vstorynum, String vreadme, String qskill, String q, class_TraitAnswer oa, class_TraitAnswer ob, class_TraitAnswer oc, class_TraitAnswer od)
   {
      rare = vrare;
      storynum = vstorynum;
      readme = vreadme;
      question = q;
      opta = oa;
      optb = ob;
      optc = oc;
      optd = od;
      qual_skill = qskill;
   }

   public class_FutureQuestion(int vstorynum, String q, class_TraitAnswer oa, class_TraitAnswer ob, class_TraitAnswer oc, class_TraitAnswer od)
   {
      rare = 0;
      storynum = vstorynum;
      readme = null;
      question = q;
      opta = oa;
      optb = ob;
      optc = oc;
      optd = od;
      qual_skill = null;
   }
   public class_FutureQuestion(int vstorynum, int vrare, String q, class_TraitAnswer oa, class_TraitAnswer ob, class_TraitAnswer oc, class_TraitAnswer od)
   {
      rare = vrare;
      storynum = vstorynum;
      readme = null;
      question = q;
      opta = oa;
      optb = ob;
      optc = oc;
      optd = od;
      qual_skill = null;
   }

   public String getQuestion() {return question;}
   public class_TraitAnswer getOptA() { return opta;}
   public class_TraitAnswer getOptB() { return optb;}
   public class_TraitAnswer getOptC() {return optc;}
   public class_TraitAnswer getOptD() {return optd;}
   public int getRare(){return rare;}
   public int getStorynum(){return storynum;}
   public String getQual_skill(){return qual_skill;}
}
