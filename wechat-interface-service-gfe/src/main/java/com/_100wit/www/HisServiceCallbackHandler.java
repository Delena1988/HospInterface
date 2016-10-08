
/**
 * HisServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com._100wit.www;

    /**
     *  HisServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class HisServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public HisServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public HisServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for findMedicardList method
            * override this method for handling normal response from findMedicardList operation
            */
           public void receiveResultfindMedicardList(
                    HisServiceStub.FindMedicardListResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findMedicardList operation
           */
            public void receiveErrorfindMedicardList(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for offLineRegistreNotice method
            * override this method for handling normal response from offLineRegistreNotice operation
            */
           public void receiveResultoffLineRegistreNotice(
                    HisServiceStub.OffLineRegistreNoticeResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from offLineRegistreNotice operation
           */
            public void receiveErroroffLineRegistreNotice(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyPatientMobile method
            * override this method for handling normal response from modifyPatientMobile operation
            */
           public void receiveResultmodifyPatientMobile(
                    HisServiceStub.ModifyPatientMobileResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyPatientMobile operation
           */
            public void receiveErrormodifyPatientMobile(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAddress001 method
            * override this method for handling normal response from getAddress001 operation
            */
           public void receiveResultgetAddress001(
                    HisServiceStub.GetAddress001ResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAddress001 operation
           */
            public void receiveErrorgetAddress001(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findBhmMedicard method
            * override this method for handling normal response from findBhmMedicard operation
            */
           public void receiveResultfindBhmMedicard(
                    HisServiceStub.FindBhmMedicardResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findBhmMedicard operation
           */
            public void receiveErrorfindBhmMedicard(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for newCard method
            * override this method for handling normal response from newCard operation
            */
           public void receiveResultnewCard(
                    HisServiceStub.NewCardResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from newCard operation
           */
            public void receiveErrornewCard(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for hisForHzfwhService method
            * override this method for handling normal response from hisForHzfwhService operation
            */
           public void receiveResulthisForHzfwhService(
                    HisServiceStub.HisForHzfwhServiceResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from hisForHzfwhService operation
           */
            public void receiveErrorhisForHzfwhService(Exception e) {
            }
                


    }
    