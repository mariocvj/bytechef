/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.component.xero.constant;

import com.bytechef.component.definition.Property;

import static com.bytechef.component.definition.ComponentDSL.string;

/**
 * @author Mario Cvjetojevic
 */
public final class XeroConstants {

    public static final String XERO = "xero";
    public static final String TENANT_ID = "tenantId";
    public static final String CREATE_CONTACT = "createContact";
    public static final String CREATE_INVOICE = "createInvoice";
    public static final String NAME = "Name";
    public static final String CONTACT_ID = "ContactId";
    public static final String CONTACT_NUMBER = "ContactNumber";
    public static final String ACCOUNT_NUMBER = "AccountNumber";
    public static final String COMPANY_NUMBER = "CompanyNumber";
    public static final String FIRST_NAME = "FirstName";
    public static final String LAST_NAME = "LastName";
    public static final String EMAIL_ADDRESS = "EmailAddress";
    public static final String BANK_ACCOUNT_DETAILS = "BankAccountDetails";
    public static final String TAX_NUMBER = "TaxNumber";
    public static final String ACCOUNTS_RECEIVABLE_TAX_TYPE = "AccountsReceivableTaxType";
    public static final String ACCOUNTS_PAYABLE_TAX_TYPE = "AccountsPayableTaxType";
    public static final String IS_SUPPLIER = "IsSupplier";
    public static final String IS_CUSTOMER = "IsCustomer";
    public static final String DEFAULT_CURRENCY = "DefaultCurrency";
    public static final String XERO_NETWORK_KEY = "XeroNetworkKey";
    public static final String SALES_DEFAULT_ACCOUNT_CODE = "SalesDefaultAccountCode";
    public static final String PURCHASES_DEFAULT_ACCOUNT_CODE = "PurchasesDefaultAccountCode";
    public static final String TRACKING_CATEGORY_NAME = "TrackingCategoryName";
    public static final String TRACKING_OPTION_NAME = "TrackingOptionName";

    public static final String TYPE = "Type";
    public static final String ACCPAY = "ACCPAY";
    public static final String ACCREC = "ACCREC";
    public static final String CONTACT = "CONTACT";
    public static final String LINE_ITEM_DESCRIPTION = "lineItemDescription";
    public static final String LINE_ITEMS_AMMOUNT = "lineItemsAmmount";
    public static final String LINE_ITEMS = "lineItems";
    public static final String LINE_ITEM = "lineItem";

    public static final String DESCRIPTION = "Description";
    public static final String QUANTITY = "Quantity";
    public static final String UNIT_AMOUNT = "UnitAmount";
    public static final String ITEM_CODE = "ItemCode";
    public static final String ACCOUNT_CODE = "AccountCode";
    public static final String LINE_ITEM_ID = "LineItemID";
    public static final String TAX_TYPE = "TaxType";
    public static final String TAX_AMOUNT = "TaxAmount";
    public static final String LINE_AMOUNT = "LineAmount";


//    public static final Property LINE_ITEM_PROPERTY =
//
//        string(OCR_LANGUAGE)
//            .label("OCR Language")
//            .description(
//                "A language hint for OCR processing during image import (ISO 639-1 code).")



//    public static final String  = "";
//    public static final String  = "";
//    public static final String  = "";
//    public static final String  = "";
//    public static final String  = "";
//    public static final String  = "";
//    public static final String  = "";

    private XeroConstants() {
    }
}
