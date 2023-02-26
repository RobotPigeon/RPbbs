import { defineStore } from 'pinia';

export default defineStore({
    id: 'alert',
    state: () => ({
        alert: null,
    }),
    actions: {
        setAlert(newVal:any) {
            this.alert = newVal;
        },
        clearAlert() {
            this.alert = null;
        },
    },
});