package com.example.chooselife;

public class class_FutureQuestion {
   private int rare, storynum;
   private String question;
   private class_TraitAnswer opta, optb, optc, optd;
   private class_Trait[] qual_trait;
   private String qual_skill;

   public class_FutureQuestion()
   {
      rare = 0;
      storynum = 0;
      question = "";
   }

   public class_FutureQuestion(int vrare, int vstorynum, String q, class_TraitAnswer oa, class_TraitAnswer ob, class_TraitAnswer oc, class_TraitAnswer od, class_Trait[] qtrait, String qskill)
   {
      rare = vrare;
      storynum = vstorynum;
      question = q;
      opta = oa;
      optb = ob;
      optc = oc;
      optd = od;
      qual_trait = qtrait;
      qual_skill = qskill;
   }
   public class_FutureQuestion(int vrare, int vstorynum, String q, class_TraitAnswer oa, class_TraitAnswer ob, class_TraitAnswer oc, class_TraitAnswer od, class_Trait[] qtrait)
   {
      rare = vrare;
      storynum = vstorynum;
      question = q;
      opta = oa;
      optb = ob;
      optc = oc;
      optd = od;
      qual_trait = qtrait;
      qual_skill = null;
   }
   public class_FutureQuestion(int vrare, int vstorynum, String q, class_TraitAnswer oa, class_TraitAnswer ob, class_TraitAnswer oc, class_TraitAnswer od, String qskill)
   {
      rare = vrare;
      storynum = vstorynum;
      question = q;
      opta = oa;
      optb = ob;
      optc = oc;
      optd = od;
      qual_trait = null;
      qual_skill = qskill;
   }
   public class_FutureQuestion(int vrare, int vstorynum, String q, class_TraitAnswer oa, class_TraitAnswer ob, class_TraitAnswer oc, class_TraitAnswer od)
   {
      rare = vrare;
      storynum = vstorynum;
      question = q;
      opta = oa;
      optb = ob;
      optc = oc;
      optd = od;
      qual_trait = null;
      qual_skill =  null;
   }

   public String getQuestion() {return question;}
   public class_TraitAnswer getOptA() { return opta;}
   public class_TraitAnswer getOptB() { return optb;}
   public class_TraitAnswer getOptC() {return optc;}
   public class_TraitAnswer getOptD() {return optd;}
   public int getRare(){return rare;}
   public int getStorynum(){return storynum;}
   public class_Trait getQualTrait(int ind){return qual_trait[ind];}
   public String getQual_skill(){return qual_skill;}
}
