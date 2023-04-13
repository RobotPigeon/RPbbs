import axios from './'
//获取赛程信息/fm/match/list
export function getMatchList() {
    return axios.get<any>('/fm/match/list')
}

//根据球队获取球员信息，携带参数Squad:string,/fm/team/get_players
export function getPlayersByTeam(Squad: any) {
    return axios.get<any>('/fm/team/get_players', {
            Squad
    })
}
//获取球队信息，/fm/team_basic/list
export function getTeamList() {
    return axios.get<any>('/fm/team_basic/list')
}