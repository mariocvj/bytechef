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
import com.bytechef.component.definition.Option;
import com.bytechef.component.definition.OptionsDataSource;
import com.bytechef.component.definition.Parameters;
import com.xero.api.ApiClient;
import com.xero.api.client.AccountingApi;
import com.xero.models.accounting.Contacts;
import com.xero.models.accounting.Invoice;
import com.xero.models.accounting.Invoices;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;

import static com.bytechef.component.definition.Authorization.ACCESS_TOKEN;
import static com.bytechef.component.definition.ComponentDSL.ModifiableActionDefinition;
import static com.bytechef.component.definition.ComponentDSL.action;
import static com.bytechef.component.definition.ComponentDSL.option;
import static com.bytechef.component.definition.ComponentDSL.string;
import static com.bytechef.component.xero.constant.XeroConstants.ACCPAY;
import static com.bytechef.component.xero.constant.XeroConstants.ACCREC;
import static com.bytechef.component.xero.constant.XeroConstants.CREATE_INVOICE;
import static com.bytechef.component.xero.constant.XeroConstants.LINE_ITEMS;
import static com.bytechef.component.xero.constant.XeroConstants.TYPE;
import static com.bytechef.component.xero.constant.XeroConstants.CONTACT;

/**
 * @author Mario Cvjetojevic
 */
public final class XeroCreateInvoiceAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action(CREATE_INVOICE)
        .title("Create invoice")
        .description("Description")
        .properties(
            string(TYPE)
                .label("Invoice type")
                .description(
                    "Type of an invoice.")
                .options(
                    option(ACCPAY, ACCPAY),
                    option(ACCREC, ACCREC))
                .required(true),
            string(CONTACT)
                .label("Invoice type")
                .description(
                    "Full name of a contact or organisation.")
        .options((OptionsDataSource.ActionOptionsFunction<String>) XeroCreateInvoiceAction::getContactOptions)
                .required(true),
            string(LINE_ITEMS)
                .label("Invoice type")
                .description(
                    "The LineItems collection can contain any number of individual LineItem sub-elements. At least " +
                        "one is required to create a complete Invoice.")
                .options(
                    option(ACCPAY, ACCPAY),
                    option(ACCREC, ACCREC))
                .required(true))
        .outputSchema(string())
        .perform(XeroCreateInvoiceAction::perform);

    private XeroCreateInvoiceAction() {
    }

    public static Object perform(
        Parameters inputParameters, Parameters connectionParameters, ActionContext actionContext) throws IOException {

        String accessToken = connectionParameters.getRequiredString(ACCESS_TOKEN);
        ApiClient defaultClient = new ApiClient();

        AccountingApi apiInstance = AccountingApi.getInstance(defaultClient);

        String xeroTenantId = "YOUR_XERO_TENANT_ID";
        String idempotencyKey = "KEY_VALUE";

        Invoice invoice = new Invoice();

        if (inputParameters.getRequiredString(TYPE).equals(ACCPAY)){
            invoice.setType(Invoice.TypeEnum.ACCPAY);
        }else {
            invoice.setType(Invoice.TypeEnum.ACCREC);
        }
        //invoice.setContact();
        //invoice.setLineItems();

        Invoices invoices = new Invoices();
        invoices.addInvoicesItem(invoice);

        //Contacts result = apiInstance.createContacts(accessToken, xeroTenantId, contacts, idempotencyKey, true);

        return null;
    }

    public static List<Option<String>> getContactOptions(
        Parameters inputParameters, Parameters connectionParameters, String searchText, ActionContext context)
        throws IOException {

        String accessToken = "YOUR_ACCESS_TOKEN";
        ApiClient defaultClient = new ApiClient();

        AccountingApi apiInstance = AccountingApi.getInstance(defaultClient);
        String xeroTenantId = "YOUR_XERO_TENANT_ID";

        String order = "Name ASC";

        Contacts result = apiInstance.getContacts(accessToken, xeroTenantId, null, null, order, null, 1, true, null, null);

        return result.getContacts()
            .stream()
            .filter(contact -> StringUtils.isNotEmpty(searchText) &&
                StringUtils.startsWith(contact.getName(), searchText))
            .map(contact -> (Option<String>) option(contact.getName(), contact.getContactID().toString()))
            .toList();
    }
}
