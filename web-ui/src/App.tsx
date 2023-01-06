import './App.css'
import Left from "./components/left/Left";
import Right from "./components/right/Right";
import React, {createContext,  useState} from "react";
import Group from "./type/Group";
import GlobalContext from "./type/GlobalContext";
import ContextMenu from "./components/common/ContextMenu";
import ContextMenuParam from "./type/ContextMenuParam";
import Position from "./type/Position";


const defaultGroup = {
    id : 0,
    label: "uncompleted",
    name: "未完成",
    num: 0
}
// @ts-ignore
export const globalContext = createContext<GlobalContext>()

function App() {
    const [currentGroup, setCurrentGroup] = useState<Group>(defaultGroup)
    const [updateFlag, setUpdateFlag] = useState<boolean>(false)
    const [contextMenuParams, setContextMenuParam] = useState<ContextMenuParam>({
        position : {
            x : 0,
            y: 0
        },
        show : false,
        callback : () => {}
    })

    const contextMenu = contextMenuParams.show && <ContextMenu position={contextMenuParams.position} callback={contextMenuParams.callback}/>

    const showContextMenuAction = (position : Position, callback : () => void) => {
        setContextMenuParam({
            show : true,
            position,
            callback
        })
    }

    const hideContextMenuAction = () => {
        setContextMenuParam({
            ...contextMenuParams,
            show : false
        })
    }

    const contextValue = {
        currentGroup,
        setCurrentGroup,
        updateFlag: updateFlag,
        triggerUpdate: () => setUpdateFlag(!updateFlag),
        showContextMenu : showContextMenuAction
    }
    return (
    <div className="app" onClick={(e) => hideContextMenuAction()}>
        <globalContext.Provider value={contextValue}>
            <Left/>
            <Right/>
            {contextMenu}
        </globalContext.Provider>
    </div>
    )
}

export default App