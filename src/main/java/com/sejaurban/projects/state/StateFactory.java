package com.sejaurban.projects.state;

public class StateFactory {
	 public static StatusState create(String stateName) {
		 StatusState actionObject = null;
         String className = "com.sejaurban.projects.state."+stateName+"State";
         Class<?> clazz = null;
         Object object = null;
         try {
        	 clazz = Class.forName(className);
        	 object = clazz.newInstance();
         } catch(Exception ex) {
             return null;
         }
         if(!(object instanceof StatusState)) return null;
         actionObject = (StatusState) object;
         return actionObject;
     }
}
