export default {
    namespaced: true,
    state: {
        tableData: [{
            id: 1,
            serialnumber: '20211001 5TEBA.820.H10016.1',
            name: '套装箱1',
            version: 'A.2',
            state: '开工',
            number: 1,
            code: '未打印',
            creator: 'SLMadmin',
            children: [{
                id: 31,
                serialnumber: '20211001 5TEBA.820.H10016.002',
                name: '高压套装箱',
                version: 'A.2',
                state: '开工',
                number: 1,
                code: '未打印',
                creator: 'SLMadmin',
                children: [{
                    id: 311,
                    serialnumber: '20211001 5TEBA.820.H10016.003',
                    name: '高压套管',
                    version: 'A.1',
                    state: '开工',
                    number: 1,
                    code: '已打印',
                    creator: 'SLMadmin'
                }]
            }]
        }, {
            id: 2,
            serialnumber: '20211001 5TEBA.820.H10016.2',
            name: '套装箱2',
            version: 'A.2',
            state: '开工',
            number: '2',
            code: '未打印',
            creator: 'SLMadmin'
        }, {
            id: 3,
            serialnumber: '20211001 5TEBA.820.H10016.3',
            name: '套装箱3',
            version: 'A.1',
            state: '开工',
            number: '3',
            code: '未打印',
            creator: 'SLMadmin'
        }],
        dragBoxData: [],
        clickRowInfo: {}
        // serialnumber: '',
        // name: '',
        // number: ''
    },
    getters: {},
    actions: {},
    mutations: {
        DRAG_BOX(state, dragBoxData) {
            // console.log(dragBoxData);
            state.dragBoxData = dragBoxData;
            // state.serialnumber = dragBoxData.serialnumber;
            // state.name = dragBoxData.name;
            // state.number = dragBoxData.number;
        },
        CLICK_ROW_INFO(state, clickRowInfo) {
            // console.log(clickRowInfo);
            state.clickRowInfo = clickRowInfo;
        },
        NEW_TABLE_DATA(state, newTableData) {
            state.tableData = newTableData
        }
    }
}