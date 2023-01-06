import React, {useContext, useEffect, useState} from "react";
import LeftItem from "./LeftItem";
import * as api from "../../api/api";
import {globalContext} from "../../App";
import Group from "../../type/Group";
import CommonAdd from "../common/CommonAdd";
import {addGroup} from "../../api/api";
export default function Left() {

    // state
    const [defaultList, setDefaultList] = useState<Group[]>([])

    const [selfList, setSelfList] = useState<Group[]>([])


    const {updateFlag} = useContext(globalContext)

    // action
    const loadDefaultGroup = async () => {
        const defaultListInit : Group[] = [
            {
                id : 0,
                label: "all",
                name: "全部",
                num: 0
            },
            {
                id : 0,
                label: "uncompleted",
                name: "未完成",
                num: 0
            },
            {
                id : 0,
                label: "completed",
                name: "已完成",
                num: 0
            },
            {
                id : 0,
                label: "star",
                name: "星标",
                num: 0
            }
        ]
        const data = await api.defaultGroupTaskCount().then(res => res.data).then(res => res.data)
        defaultListInit.forEach(item => item.num = item.label && data[item.label])
        setDefaultList(defaultListInit)
    }
    const loadSelfGroup =  async() => {
        const data = await api.allGroup().then(res => res.data).then(res => res.data)
        setSelfList(data)
    }
    const load = () => {
        loadDefaultGroup().then()
        loadSelfGroup().then()
    }
    useEffect(load,[updateFlag]);

    const addGroupAction = (name : string) => {
        addGroup(name).then(res => res.data).then(res => {
            if (res.code === 200) loadSelfGroup().then()
            else console.error(res.msg)
        })
    }



    // render
    const defaultListItems = defaultList.map((item, key) =>
        <LeftItem group={item} key={key}/>)
    const selfListItems = selfList.map((item, key) =>
        <LeftItem group={item} key={key}/>)



    return (
        <div className="left">
            <div className="group">
                {defaultListItems}
                {selfListItems}
            </div>
            <CommonAdd placeholder="添加分组..." addAction={addGroupAction}/>
        </div>
    )
}