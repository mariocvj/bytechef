import {create} from 'zustand';
import {devtools} from 'zustand/middleware';

interface LeftSidebarState {
    leftSidebarOpen: boolean;
    setLeftSidebarOpen: (leftSidebarStatus: boolean) => void;
}

const useLeftSidebarStore = create<LeftSidebarState>()(
    devtools(
        (set) => ({
            leftSidebarOpen: false,
            setLeftSidebarOpen: (leftSidebarOpen) =>
                set(() => ({
                    leftSidebarOpen,
                })),
        }),
        {
            name: 'left-sidebar',
        }
    )
);

export default useLeftSidebarStore;
