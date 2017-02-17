/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.ballerinalang.nativeimpl.lang.datatable;

import org.ballerinalang.bre.Context;
import org.ballerinalang.model.types.TypeEnum;
import org.ballerinalang.model.values.BDataTable;
import org.ballerinalang.model.values.BDouble;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.natives.AbstractNativeFunction;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.ReturnType;

/**
 * Native function to get double value of a given column name.
 * ballerina.model.datatables:getDouble(datatable, string)
 *
 * @since 0.8.0
 */
@BallerinaFunction(
        packageName = "ballerina.lang.datatables",
        functionName = "getDouble",
        args = {@Argument(name = "dt", type = TypeEnum.DATATABLE),
                @Argument(name = "name", type = TypeEnum.STRING)},
        returnType = {@ReturnType(type = TypeEnum.DOUBLE)},
        isPublic = true
)
public class GetDoubleByName extends AbstractNativeFunction {

    public BValue[] execute(Context ctx) {
        BDataTable dataTable = (BDataTable) getArgument(ctx, 0);
        String columnName = (getArgument(ctx, 1)).stringValue();
        return getBValues(new BDouble(dataTable.getDouble(columnName)));
    }
}