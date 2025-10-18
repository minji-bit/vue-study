<template>
    <div>
        {{ sendProps1 }}
    </div>
    <div>
        {{ sendProps2 }}
    </div>
    <div>
        {{ sendProps3 }}
    </div>
</template>

<script>
export default {
    props :{
        sendProps1:String,
        sendProps2:Number,
        sendProps3:Object,
    },
    data () {
        

        return {}
    }
}
</script>

<style lang="scss" scoped>

</style>