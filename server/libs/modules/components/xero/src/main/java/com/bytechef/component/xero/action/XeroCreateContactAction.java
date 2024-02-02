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

package com.bytechef.component.xero.action;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Parameters;
import com.xero.api.ApiClient;
import com.xero.api.client.AccountingApi;
import com.xero.models.accounting.Contact;
import com.xero.models.accounting.Contacts;
import com.xero.models.accounting.Phone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.bytechef.component.definition.Authorization.ACCESS_TOKEN;
import static com.bytechef.component.definition.ComponentDSL.ModifiableActionDefinition;
import static com.bytechef.component.definition.ComponentDSL.action;
import static com.bytechef.component.definition.ComponentDSL.bool;
import static com.bytechef.component.definition.ComponentDSL.string;
import static com.bytechef.component.xero.constant.XeroConstants.ACCOUNTS_PAYABLE_TAX_TYPE;
import static com.bytechef.component.xero.constant.XeroConstants.ACCOUNTS_RECEIVABLE_TAX_TYPE;
import static com.bytechef.component.xero.constant.XeroConstants.ACCOUNT_NUMBER;
import static com.bytechef.component.xero.constant.XeroConstants.ADDRESSES;
import static com.bytechef.component.xero.constant.XeroConstants.BANK_ACCOUNT_DETAILS;
import static com.bytechef.component.xero.constant.XeroConstants.CONTACT_ID;
import static com.bytechef.component.xero.constant.XeroConstants.CONTACT_NUMBER;
import static com.bytechef.component.xero.constant.XeroConstants.CONTACT_PERSONS;
import static com.bytechef.component.xero.constant.XeroConstants.CONTACT_STATUS;
import static com.bytechef.component.xero.constant.XeroConstants.CREATE_CONTACT;
import static com.bytechef.component.xero.constant.XeroConstants.DEFAULT_CURRENCY;
import static com.bytechef.component.xero.constant.XeroConstants.EMAIL_ADDRESS;
import static com.bytechef.component.xero.constant.XeroConstants.FIRST_NAME;
import static com.bytechef.component.xero.constant.XeroConstants.IS_CUSTOMER;
import static com.bytechef.component.xero.constant.XeroConstants.IS_SUPPLIER;
import static com.bytechef.component.xero.constant.XeroConstants.LAST_NAME;
import static com.bytechef.component.xero.constant.XeroConstants.NAME;
import static com.bytechef.component.xero.constant.XeroConstants.PAYMENT_TEAMS;
import static com.bytechef.component.xero.constant.XeroConstants.PHONES;
import static com.bytechef.component.xero.constant.XeroConstants.PURCHASES_DEFAULT_ACCOUNT_CODE;
import static com.bytechef.component.xero.constant.XeroConstants.PURCHASES_TRACKING_CATEGORIES;
import static com.bytechef.component.xero.constant.XeroConstants.SALES_DEFAULT_ACCOUNT_CODE;
import static com.bytechef.component.xero.constant.XeroConstants.SALES_TRACKING_CATEGORIES;
import static com.bytechef.component.xero.constant.XeroConstants.TAX_NUMBER;
import static com.bytechef.component.xero.constant.XeroConstants.TRACKING_CATEGORY_NAME;
import static com.bytechef.component.xero.constant.XeroConstants.TRACKING_OPTION_NAME;
import static com.bytechef.component.xero.constant.XeroConstants.XERO_NETWORK_KEY;

/**
 * @author Mario Cvjetojevic
 */
public final class XeroCreateContactAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action(CREATE_CONTACT)
        .title("Create contact")
        .description("Description")
        .properties(
            string(NAME)
                .label("Name")
                .description(
                    "Full name of a contact or organisation.")
                .maxLength(255)
                .required(true),
            string(CONTACT_ID)
                .label("Contact ID")
                .description(
                    "Xero identifier."),
            string(CONTACT_NUMBER)
                .label("Contact number")
                .description(
                    "This can be updated via the API only i.e. This field is read only on the Xero contact screen, " +
                        "used to identify contacts in external systems. If the Contact Number is used, this is " +
                        "displayed as Contact Code in the Contacts UI in Xero.")
                .maxLength(50),
            string(ACCOUNT_NUMBER)
                .label("Account number")
                .description(
                    "A user defined account number. This can be updated via the API and the Xero UI.")
                .maxLength(50),
            string(CONTACT_STATUS)//TODO
                .label("Contact status")
                .description(
                    "Current status of a contact."),
            string(FIRST_NAME)
                .label("First name")
                .description(
                    "First name of contact person.")
                .maxLength(255),
            string(LAST_NAME)
                .label("Last name")
                .description(
                    "Last name of contact person.")
                .maxLength(255),
            string(CONTACT_NUMBER)
                .label("Company Number")
                .description(
                    "Company registration number.")
                .maxLength(50),
            string(EMAIL_ADDRESS)
                .label("Email address")
                .description(
                    "Email address of contact person (umlauts not supported). ")
                .maxLength(255),
            string(CONTACT_PERSONS)//TODO
                .label("")
                .description(
                    ""),
            string(BANK_ACCOUNT_DETAILS)
                .label("Bank account details")
                .description(
                    "Bank account number of contact."),
            string(TAX_NUMBER)
                .label("Tax number")
                .description(
                    "Tax number of contact – this is also known as the ABN (Australia), GST Number (New Zealand), " +
                        "VAT Number (UK) or Tax ID Number (US and global) in the Xero UI depending on which " +
                        "regionalized version of Xero you are using.")
                .maxLength(50),
            string(ACCOUNTS_RECEIVABLE_TAX_TYPE)
                .label("Accounts receivable tax type")
                .description(
                    "Default tax type used for contact on AR invoices."),
            string(ACCOUNTS_PAYABLE_TAX_TYPE)
                .label("Accounts payable tax type")
                .description(
                    "Default tax type used for contact on AP invoices."),
            string(ADDRESSES)//TODO
                .label("Addresses")
                .description(
                    "Store certain address types for a contact."),
            string(PHONES)//TODO
                .label("Phones")
                .description(
                    "Store certain phone types for a contact."),
            bool(IS_SUPPLIER)
                .label("Is supplier")
                .description(
                    "Boolean that describes if a contact that has any AP invoices entered against them. Cannot be " +
                        "set via PUT or POST – it is automatically set when an accounts payable invoice is generated " +
                        "against this contact."),
            bool(IS_CUSTOMER)
                .label("Is customer")
                .description(
                    "Boolean that describes if a contact has any AR invoices entered against them. Cannot be set " +
                        "via PUT or POST – it is automatically set when an accounts receivable invoice is generated " +
                        "against this contact."),
            string(DEFAULT_CURRENCY)
                .label("Default currency")
                .description(
                    "Default currency for raising invoices against contact."),
            string(XERO_NETWORK_KEY)
                .label("Xero network key")
                .description(
                    "Store XeroNetworkKey for contacts."),
            string(SALES_DEFAULT_ACCOUNT_CODE)//TODO
                .label("Sales default account code")
                .description(
                    "The default sales account code for contacts."),
            string(PURCHASES_DEFAULT_ACCOUNT_CODE)//TODO
                .label("Purchases default account code")
                .description(
                    "The default purchases account code for contacts."),
            string(SALES_TRACKING_CATEGORIES)//TODO
                .label("Sales tracking categories")
                .description(
                    "The default sales tracking categories for contacts."),
            string(PURCHASES_TRACKING_CATEGORIES)//TODO
                .label("Purchases tracking categories")
                .description(
                    "The default purchases tracking categories for contacts."),
            string(TRACKING_CATEGORY_NAME)
                .label("Tracking category name")
                .description(
                    "The name of the Tracking Category assigned to the contact under SalesTrackingCategories and " +
                        "PurchasesTrackingCategories"),
            string(TRACKING_OPTION_NAME)
                .label("Tracking option name")
                .description(
                    "The name of the Tracking Option assigned to the contact under SalesTrackingCategories and " +
                        "PurchasesTrackingCategories"),
            string(PAYMENT_TEAMS)//TODO
                .label("Payment terms")
                .description(
                    "The default payment terms for the contact."))
        .outputSchema(string())
        .perform(XeroCreateContactAction::perform);

    private XeroCreateContactAction() {
    }

    public static Object perform(
        Parameters inputParameters, Parameters connectionParameters, ActionContext actionContext) throws IOException {

        String accessToken = connectionParameters.getRequiredString(ACCESS_TOKEN);
        ApiClient defaultClient = new ApiClient();

        AccountingApi apiInstance = AccountingApi.getInstance(defaultClient);
        String xeroTenantId = "YOUR_XERO_TENANT_ID";
        String idempotencyKey = "KEY_VALUE";
        Boolean summarizeErrors = true;

        Phone phone = new Phone();
        phone.setPhoneNumber("555-1212");
        phone.setPhoneType(com.xero.models.accounting.Phone.PhoneTypeEnum.MOBILE);

        List<Phone> phones = new ArrayList<Phone>();
        phones.add(phone);

        Contact contact = new Contact();
        contact.setName("Bruce Banner");
        contact.setEmailAddress("hulk@avengers.com");
        contact.setPhones(phones);

        Contacts contacts = new Contacts();
        contacts.addContactsItem(contact);

        Contacts result = apiInstance.createContacts(accessToken, xeroTenantId, contacts, idempotencyKey, summarizeErrors);
        System.out.println(result);

        return null;
    }
}
